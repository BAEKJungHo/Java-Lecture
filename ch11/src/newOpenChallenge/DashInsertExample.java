package newOpenChallenge;

import java.util.Scanner;

public class DashInsertExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요");
		String str = scan.nextLine();
		dashInsert(str);
		scan.close();
	}
	
	public static void dashInsert(String str) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		for(int i=0; i<sb.length()-1; i++) {
			if(((int)str.charAt(i) % 2 == 0) && ((int)str.charAt(i+1) % 2 == 0) && ((int)str.charAt(i+1) != 42) && ((int)str.charAt(i) != 42)) {
				sb.insert(i+1, "*");
				str = sb.toString();
			}
			else if(((int)str.charAt(i) % 2 != 0) && ((int)str.charAt(i+1) % 2 != 0) && ((int)str.charAt(i+1) != 45) && ((int)str.charAt(i) != 45)) {
				sb.insert(i+1, "-");
				str = sb.toString();
			}
		}
		
		System.out.println(sb.toString());
		
	}
}