package exercise;

public class MemberExercise {
	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
		Member user2 = new Member("강자바", "java");
		
		MemberService memberservice = new MemberService();
		boolean result = memberservice.login("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberservice.logout("hong");
		} 
		else {
			System.out.println("id or password가 올바르지 않습니다.");
		}
	}
}
