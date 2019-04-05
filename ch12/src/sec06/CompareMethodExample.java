package sec06;

public class CompareMethodExample {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		if(result1) {
			System.out.println("논리적 동등 객체");
		} else {
			System.out.println("논리적 동등 객체 아님");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("user1", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("user2", "홍길동");
		boolean result2 = Util.compare(p3, p4);
		if(result2) {
			System.out.println("논리적 동등 객체");
		} else {
			System.out.println("논리적 동등 객체 아님");
		}

	}
}
