package Openchallenge;

public class NumberSplitExample {
	public static void main(String[] args) {
		int sum = 0;
		for (int i=10; i<=99; i++) {
			int firstDigit = i / 10;
			int secondDigit = i % 10;
			sum += firstDigit * secondDigit;
		}
		for (int i=100; i<=999; i++) {
			int firstDigit = i / 100;
			int secondDigit = (i / 10) % 10;
			int thirdDigit = i % 10;
			sum += firstDigit * secondDigit * thirdDigit;
		}
		System.out.println(sum);
	 }
  }