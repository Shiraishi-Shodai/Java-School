package stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class インクリメントデクリメント {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("ken",100);
		//map.put("ken",100);
		List<String> list = new ArrayList<>();
		Map<String,Integer> map2 = new HashMap<>();
		Integer v = map.remove("ken");
		map2.put("ken",100);
		map2.put("taka",100);
		System.out.println(v);
	}
}
