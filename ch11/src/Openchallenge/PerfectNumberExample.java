package Openchallenge;

import java.util.Scanner;
public class PerfectNumberExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int number = Integer.parseInt(scan.nextLine());
		
		for(int i=6; i<=number; i++) {
			int sum = 0;
			for(int k=1; k<i; k++) {
				if(i%k == 0) {
					sum += k;
				}
			}
			if(sum == i) {
				System.out.println(i);
			}
		}
		scan.close();
	}
}
