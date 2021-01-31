package metier.dao.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRound {

	public static void main(String[] args) {
		
		Map<String, List<String>> test = new HashMap<String, List<String>>();
		
		List<String> list = new ArrayList<String>();
		list.add("el gourari");
		list.add("el fahfouhi");
		list.add("el hachimi");
		
		test.put("youssef", list);
		
		List<String> lst = new ArrayList<String>();
		
		System.out.println(test.getOrDefault("youssef", lst ).get(0)); // entry.getOrDefault(entry.key, entry.value).get(8)

	}

}
