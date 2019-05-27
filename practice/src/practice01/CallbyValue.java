package practice01;

public class CallbyValue {
	public static void main(String[] args) {
		// Person 객체
		// getter()와 setter()를 통한 Call by reference 흉내내기 
		Person name = new Person("John", "Test");
		System.out.println(name.getName()); // John
		name.setName("Mike");
		System.out.println(name.getName()); // Mike
		
		// Call by value
		name.setStr("RED");
		System.out.println(name.getStr());
		
		person(name);
		System.out.println(name.toString());
		
		// String 객체
		String ellis = new String("Ellis");
		String nick = new String("Nick");
		System.out.println(ellis + nick); // EllisNick
		
		// swap 호출
		swap(ellis, nick); // NickEllis
		System.out.println(ellis + nick); // EllisNick
		
		// String에 문자열 넣기
		String rochelle = "Rochelle";
		String coach = "Coach";
		System.out.println(rochelle + coach); // RochelleCoach
		
		// swap 호출
		swap(rochelle, coach); // CoachRochelle
		System.out.println(rochelle + coach); // RochelleCoach
	}
	
	static void swap(String a, String b) {
		String temp = a;
		a = b;
		b = temp;
		System.out.println(a+b); // 메소드 내부에서는 값이 바뀌지만 메소드를 벗어나면 소용 없다.
	}
	
	static void person(Person p) {
		p = new Person("Bob", "Kiz"); // Bob, Kiz라는 새로운 객체가 생성
		System.out.println(p.toString()); // 메소드 내부에서는 값이 변경 
	}
}
