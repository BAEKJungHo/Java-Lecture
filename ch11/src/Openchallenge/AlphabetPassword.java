package Openchallenge;

import java.util.Scanner;
import java.util.StringTokenizer;
public class AlphabetPassword {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���ڿ��� ���ڸ� �Է��ϼ��� : ");
		String str = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		StringBuilder numSb = new StringBuilder();
		
		sb.append(st.nextToken()); // ���ĺ� 
		numSb.append(st.nextToken()); // ����
		
		String alphabet = sb.toString(); 
		int number = Integer.parseInt(numSb.toString());
		
		for(int i=0; i<alphabet.length(); i++) {
			sb.setCharAt(i, (char) (alphabet.charAt(i)+number));
		}
		
		System.out.println(sb.toString());
		scan.close();

	}
}
