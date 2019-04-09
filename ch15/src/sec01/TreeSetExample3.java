package sec01;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetExample3 {
	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("apple");
		treeSet.add("banana");
		treeSet.add("orange");
		treeSet.add("starwberry");
		treeSet.add("wattermelon");
		treeSet.add("mango");
		treeSet.add("grape");
		
		System.out.println("단어 검색");
		NavigableSet<String> rangeSet = treeSet.subSet("a", true, "g", true);
		for(String word : rangeSet) {
			System.out.println(word);
		}

	}
}
