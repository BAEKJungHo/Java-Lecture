package Openchallenge;

public class CeaserPasswordExample {
	public static void main(String[] args) {
		
		dashInsert("4546793");
	}
	
	public static void dashInsert(String str) {
		
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		int[] number = new int[sb.length()];
		for(int i=0; i<number.length; i++) {
			if((int)str.charAt(i) == 57) { number[i] = 9; } 
			else if((int)str.charAt(i) == 56) { number[i] = 8; } 
			else if((int)str.charAt(i) == 55) { number[i] = 7; } 
			else if((int)str.charAt(i) == 54) { number[i] = 6; } 
			else if((int)str.charAt(i) == 53) { number[i] = 5; } 
			else if((int)str.charAt(i) == 52) { number[i] = 4; } 
			else if((int)str.charAt(i) == 51) { number[i] = 3; } 
			else if((int)str.charAt(i) == 50) { number[i] = 2; } 
			else if((int)str.charAt(i) == 49) { number[i] = 1; } 
		}
		
		for(int i=0; i<number.length-1; i++) {
			if((number[i] % 2 == 0) && (number[i+1] % 2 == 0)) {
				sb.insert(i, "*");
				count++;
			}
			else if((number[i] % 2 != 0) && (number[i+1] % 2 != 0)) {
				sb.insert(i, "-");
			}
		
		}
		System.out.println(sb.toString());

	}
}
