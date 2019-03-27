package Openchallenge;

public class CeaserPasswordExample {
	public static void main(String[] args) {
		
		dashInsert("4546793");
	}
	
	public static void dashInsert(String str) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		int count = sb.length();
		for(int i=0; i<count-1; i++) {
			if(((int)str.charAt(i) % 2 == 0) && ((int)str.charAt(i+1) % 2 == 0) && ((int)str.charAt(i+1) != 42) && ((int)str.charAt(i) != 42)) {
				sb.insert(i+1, "*");
				str = sb.toString();
				count++;
			}
			else if(((int)str.charAt(i) % 2 != 0) && ((int)str.charAt(i+1) % 2 != 0) && ((int)str.charAt(i+1) != 45) && ((int)str.charAt(i) != 45)) {
				sb.insert(i+1, "-");
				str = sb.toString();
				count++;
			}
		}
		
		System.out.println(sb.toString());
		
	}
}