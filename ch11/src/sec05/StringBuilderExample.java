package sec05;

public class StringBuilderExample {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Java");
		sb.append("Programming");
		
		sb.insert(4, "2");
		sb.setCharAt(4, '8');

	}
}
