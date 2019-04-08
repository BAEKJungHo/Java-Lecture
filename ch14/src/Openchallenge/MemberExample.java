package Openchallenge;

public class MemberExample {
	public static void main(String[] args) {
		Member john = new Member("john", "jh", "jh123", 26);
		Member mike = new Member("mike", "mk", "mk123", 25);
		
		System.out.println(john.compareTo(mike));
	}
}
