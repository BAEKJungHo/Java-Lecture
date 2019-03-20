package openchallenge;

import java.util.Scanner;
public class ArithmeticTest {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		int arithmetic = 0;
		
		Add add = new Add();
		Sub sub = new Sub();
		Mul mul = new Mul();
		Div div = new Div();
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("수행할 사칙연산을 고르세요(1. 덧셈 / 2. 뺄셈 / 3. 곱셈 / 4.나눗셈 / 5. 종료)");
			arithmetic = Integer.parseInt(scan.nextLine());
			
			if(arithmetic == 5) {
				break;
			}
			
			System.out.print("사칙연산을 할 숫자 2개를 입력하세요 :");
			
			num1 = Integer.parseInt(scan.nextLine());
			num2 = Integer.parseInt(scan.nextLine());
			
			switch(arithmetic) {
			case 1:
				add.setValue(num1, num2);
				System.out.println("덧셈 : " + add.calculate());
				break;
			case 2:
				sub.setValue(num1, num2);
				System.out.println("뺄셈 : " + sub.calculate());
				break;
			case 3: 
				mul.setValue(num1, num2);
				System.out.println("곱셈 : " + mul.calculate());
				break;
			case 4:
				div.setValue(num1, num2);
				System.out.println("나눗셈 : " + div.calculate());
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
