package sec03;

public class KoreanExample {
	public static void main(String[] args) {
		Korean k1 = new Korean("백정호", "01089241810");
		System.out.println(k1.name);
		System.out.println(k1.ssn);

		Korean k2 = new Korean("홍길동", "12345678000");
		System.out.println(k2.name);
		System.out.println(k2.ssn);
	}
}
