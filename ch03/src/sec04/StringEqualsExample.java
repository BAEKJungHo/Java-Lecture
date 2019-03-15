package sec04;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strVal1 = "백정호";
		String strVal2 = "백정호";
		String strVal3 = new String("백정호");
		
		System.out.println(strVal1 == strVal2);
		System.out.println(strVal1 == strVal3);
		System.out.println();
		System.out.println(strVal1.equals(strVal2));
		System.out.println(strVal1.equals(strVal3));

	}
}
