package sec01;

public class ArrayReferenceExample {
	public static void main(String[] args) {
		String[] str = new String[3];
		str[0] = "Java";
		str[1] = "Java";
		str[2] = new String("Java");
		
		System.out.println(str[0] == str[1]);
		System.out.println(str[0] == str[2]);
		System.out.println(str[0].equals(str[2]));
	}
}
