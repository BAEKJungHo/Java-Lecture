package sec01;

import java.util.Scanner;
public class SwitchStringExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("직급을 입력하세요");
		String position = sc.nextLine();
		
		switch(position) {
		case "부장":
			System.out.println("700");
			break;
		case "과장":
			System.out.println("500");
			break;
		default :
			System.out.println("300");
		}

	}

}
