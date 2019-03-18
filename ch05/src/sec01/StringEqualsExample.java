package sec01;

public class StringEqualsExample {
	public static void main(String[] args) {
		String str1 = "백정호";
		String str2 = "백정호";
		String name = null;
		
		if(str1 == str2) { System.out.println("주소가 같음"); }
		else { System.out.println("주소가 다름"); }
		
		if(str1.equals(str2)) { System.out.println("문자열이 같음"); }
		
		String str3 = new String("백정호");
		String str4 = new String("백정호");
		
		if(str3 == str4) { System.out.println("주소가 같음"); }
		else { System.out.println("주소가 다름"); }
		
		if(str3.equals(str4)) { System.out.println("문자열이 같음"); }
		
		name = "Java";
		System.out.println(name.length());
	}
}
