package Oepnchallenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UsedCollectionExample {

	public static void main(String[] args) {
		
		String name = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,"
				+ "박민호,전경헌,송정환,김재성,이유덕,이재영,전경헌";
		
		List<String> list = new ArrayList<>();
		TreeSet treeSet = new TreeSet();
		
		int countLee = 0;
		int countKim = 0;
		int countLeeJaeYoung = 0;
		
		StringTokenizer st = new StringTokenizer(name, ",");
		int countToken = st.countTokens();

		// 리스트에 문자열 넣고, treeSet에 List넣기
		for(int i=0; i<countToken; i++) {
			list.add(st.nextToken());
			treeSet.addAll(list);
		}
		
	    Iterator iterator = treeSet.iterator();
	    System.out.print("중복 제거 및 오름차순정렬 : ");
	    while (iterator.hasNext()) {
	      System.out.print(iterator.next() + " ");
	    }
	    System.out.println();	
	    
	    for(int i=0; i<list.size(); i++) {
			if(list.get(i).substring(0, 1).equals("이")) {
				countLee++;
			} else if(list.get(i).substring(0, 1).equals("김")) {
				countKim++;
			}
			if(list.get(i).equals("이재영")) {
				countLeeJaeYoung++;
			}
	    }
	    
		System.out.println("이씨 : " + countLee + "명");
		System.out.println("김씨 : " + countKim + "명");
		System.out.println("이재영 중복 횟수 : " + countLeeJaeYoung);
	}
}
