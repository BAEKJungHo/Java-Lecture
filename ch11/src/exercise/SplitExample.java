package exercise;

import java.util.StringTokenizer;

public class SplitExample {
	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		
		String[] strArray = str.split(",");
		
		for(String arrays : strArray) {
			System.out.println(arrays);
		}
		System.out.println();
		
		StringTokenizer st = new StringTokenizer(str, ",");
		int count = st.countTokens();
		for(int i=0; i<count; i++) {
			String str1 = st.nextToken();
			System.out.println(str1);
		}

	}
}
