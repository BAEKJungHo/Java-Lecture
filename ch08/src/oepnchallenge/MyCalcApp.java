package oepnchallenge;

import java.util.Scanner;
public class MyCalcApp {
	public static void main(String[] args) {
		Calculator cal = null;
		cal = new MyCalc();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 2개를 입력하세요 : ");
		
		int a = Integer.parseInt(scan.nextLine());
		int b = Integer.parseInt(scan.nextLine());
		
		cal.add(a, b);
		cal.subtract(a, b);
		cal.multiply(a, b);
		
		scan.close();
	}
}
