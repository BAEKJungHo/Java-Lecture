package newOpenChallenge;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CeaserPasswordExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단어와 숫자를 입력하세요 : ");
		String str = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		StringBuilder numSb = new StringBuilder();
		
		sb.append(st.nextToken()); 
		numSb.append(st.nextToken()); 
		
		String alphabet = sb.toString(); 
		int number = Integer.parseInt(numSb.toString());
		
		for(int i=0; i<alphabet.length(); i++) {
			sb.setCharAt(i, (char) (alphabet.charAt(i)+number));
		}
		
		System.out.println(sb.toString());
		scan.close();

	}
}