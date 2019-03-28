package newOpenChallenge;

import java.util.Scanner;

public class DashInsertExample2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		String str = scan.nextLine();
		dashInsert(str);
		scan.close();

	}

	public static void dashInsert(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);

		for(int i=0; i<sb.length()-1; i++) {
			switch((int)str.charAt(i)) {
			case 56:
			case 54:
			case 52:
			case 50:
				switch((int)str.charAt(i+1)) {
				case 56:
				case 54:
				case 52:
				case 50:
					sb.insert(i+1, "*");
					str = sb.toString();
					break;
				default:
					break;
				}
				break;
			case 57:
			case 55:
			case 53:
			case 51:
			case 49:
				switch((int)str.charAt(i+1)) {
				case 57:
				case 55:
				case 53:
				case 51:
				case 49:
					sb.insert(i+1, "-");
					str = sb.toString();
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	
	}
}