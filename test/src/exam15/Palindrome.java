package exam15;

public class Palindrome {

	public static void main(String[] args) {
		int max = 0;
		int a = 0, b = 0;
		for (int i=100; i<=999; i++) {
			for (int k=100; k<=999; k++) {
				if (isPalindrome(i*k)) {
					if (max < i*k) {
						a = i; b = k; max = i*k;
					}
				}
			}
		}
		System.out.println(a + ", " + b + ", " + max);
	}

	static boolean isPalindrome(int number) {
		String str = String.valueOf(number);
		int len = str.length();
		for (int i=0; i<len/2; i++) {
			if (str.charAt(i) != str.charAt(len-1-i))
				return false;
		}
		return true;
	 }
  }