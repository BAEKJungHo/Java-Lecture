package sec01;

import java.util.*;
public class HashMapExample1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("홍길동", 85);
		map.put("길동이", 89);
		map.put("동동이", 95);
		map.put("홍길동", 90);
		
		System.out.println("총 Entry 수 : " + map.size());
		
		System.out.println(map.get("홍길동"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println(key + " & " + value);
		}
		
		for(String key : keySet) {
			System.out.println(key + " & " + map.get(key));
		}
		System.out.println();
		
		map.remove("홍길동");
		System.out.println(map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " & " + value);
		}
		System.out.println();
		
		map.clear();
		System.out.println(map.size());

	}
}
