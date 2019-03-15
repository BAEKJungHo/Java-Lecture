package sec01;

import java.util.Scanner;
public class IfElseIfElseExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요");
		int score = Integer.parseInt(sc.nextLine());
		
		if(score >= 90) {
			System.out.println("점수가 100 - 90 입니다.");
			System.out.println("A");
		}
		else if(score >= 80) {
			System.out.println("점수가 89 - 80 입니다.");
			System.out.println("B");
		}
		else if(score >= 70) {
			System.out.println("점수가 79 - 70 입니다.");
			System.out.println("C");
		}
		else {
			System.out.println("점수가 70미만 입니다.");
			System.out.println("D");
		}
		sc.close();
	}
}
