<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="model.Photo" %>
<%@ page import="dao.PhotoDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<%
	PhotoDAO dao = new PhotoDAO();
	Photo photo = dao.findById(Integer.parseInt(request.getParameter("id")));

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) HH:mm:ss");
    String date = sdf.format(new Date(photo.getDate() * 1000L));
%>
<head>
<meta charset="UTF-8">
<title>Viewer Page</title>
</head>
<body>
<div align="center">
<h1>Viewer Page</h1>
<a href="#" onclick="history.go(-1)">戻る</a><br>
<hr>
<table>
<tbody>
<tr><td width='540' align='center' valign='top'>
<h2><%=photo.getTitle() %></h2>
<img width='540' border='0' src='DPImage?id=<%=photo.getId() %>'><br><br>
by <%=photo.getAuthor() %><br>
<%=date %></td>
</tr>
</tbody>
</table>
<hr>
<a href="#" onclick="history.go(-1)">戻る</a>
</div>
</body>
</html>