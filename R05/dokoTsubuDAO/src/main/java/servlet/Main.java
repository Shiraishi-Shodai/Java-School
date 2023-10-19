package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // ログインしているか確認するため
    // セッションスコープからユーザー情報を取得
    HttpSession session = request.getSession();
    User loginUser = (User) session.getAttribute("loginUser");
    if (loginUser == null) { // ログインしていない場合
      // リダイレクト
      response.sendRedirect("index.jsp");
    } else { // ログイン済みの場合
      // フォワード
      RequestDispatcher dispatcher =
          request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
      dispatcher.forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String text = request.getParameter("text");

    // 入力値チェック
    if (text != null && text.length() != 0) {
    	// つぶやきリストをデータベースから取得
	  GetMutterListLogic getMutterList = new GetMutterListLogic();
      List<Mutter> mutterList = getMutterList.selectMutter();

      // セッションスコープに保存されたユーザー情報を取得
      HttpSession session = request.getSession();
      User loginUser = (User) session.getAttribute("loginUser");

      // つぶやきをつぶやきリストに追加
      Mutter mutter = new Mutter(loginUser.getName(), text);
      
      // データベースにつぶやきリストを保存
      PostMutterLogic postMutterLogic = new PostMutterLogic();
      postMutterLogic.insertMutter(mutter);
      
      } else {
      //エラーメッセージをリクエストスコープに保存
      request.setAttribute("errorMsg", "つぶやきが入力されていません");
    }

    // メイン画面にフォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
    dispatcher.forward(request, response);
  }
}