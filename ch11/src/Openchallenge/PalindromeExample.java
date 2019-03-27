package Openchallenge;

public class PalindromeExample {
	public static void main(String[] args) {
		
		int[] buffer = new int[1000];
		int palindrome = 0;
		int mul = 0;
		int length = 0;
		
		buffer[0] = 100;
		for(int m=0; m<buffer.length; m++) {
			for(int i=100; i<1000; i++) {
				for(int k=100; k<1000; k++) {
					mul = i * k;
					String strNum = String.valueOf(mul);
					length = strNum.length();
					
					if(length == 5) {
						boolean result1 = strNum.charAt(0) == strNum.charAt(4);
						boolean result2 = strNum.charAt(1) == strNum.charAt(3);
						
						if((result1 == true) && (result2 == true)) { 
							buffer[m] = mul; 
							if(buffer[m] > palindrome) {
								palindrome = buffer[m];
							}
						}
					}
					else if(length == 6) {
						boolean result1 = strNum.charAt(0) == strNum.charAt(5);
						boolean result2 = strNum.charAt(1) == strNum.charAt(4);
						boolean result3 = strNum.charAt(2) == strNum.charAt(3);
						
						if((result1 == true) && (result2 == true) && (result3 == true)) { 
							buffer[m] = mul; 
							if(buffer[m] > palindrome) {
								palindrome = buffer[m];
							}
						}
					}
				}
			}
		}
		System.out.println("가장 큰 대칭수 : " + palindrome);
	}
}
