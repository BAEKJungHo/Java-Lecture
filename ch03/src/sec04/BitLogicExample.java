package sec04;

public class BitLogicExample {
	public static void main(String[] args) {
		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + (~45));
		
		System.out.println(toBinaryString(-8));
		System.out.println(">> 3");
		System.out.println(toBinaryString(-8 >> 3));
		System.out.println(">>> 3");
		System.out.println(toBinaryString(-8 >>> 3));

	}

	public static String toBinaryString(int i) {
		// TODO Auto-generated method stub
		String str = Integer.toBinaryString(i);
		while(str.length() < 32) {
			str = "0" + str;
		}
		return str;
	}
}
