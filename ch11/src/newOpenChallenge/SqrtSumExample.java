package newOpenChallenge;

import java.util.Scanner;
public class SqrtSumExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int N = Integer.parseInt(scan.nextLine());
		
		int sum = 0;
		int sqrtSum = 0;
		int sumSqrt = 0;

		// 제곱합
		for(int i=1; i<=N; i++) {
			sqrtSum += (i*i);
		}
		
		// 합제곱
		for(int i=1; i<=N; i++) {
			sum += i;
		}
		sumSqrt = sum*sum;
		
		System.out.println(sumSqrt - sqrtSum);
		scan.close();
	}
}