package Openchallenge;

import java.util.Scanner;
public class CeaserPasswordExercise {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		String str = scan.nextLine();
		dashInsert(str);

	}

	public static void dashInsert(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
	
		int count = sb.length()-1;
		for(int i=0; i<count; i++) {
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
					count++;
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
					count++;
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
