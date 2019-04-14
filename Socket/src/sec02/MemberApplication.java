package sec02;

public class MemberApplication {
	public static void main(String[] args) throws CloneNotSupportedException {
	    Member member = new Member(26, 10001, "John", "대전 서구", "Developer");
	
	    // member객체의 힙 영역 값을 member2객체의 힙 영역에 저장
	    Member member2 = (Member) member.clone(); // Shallow Copy
	
	    Member member3 = member.copy(); // copy()메소드에서 형변환을 미리 해줘서 따로 필요 없다
	
	    member.printMemberAttribute();
	    System.out.println();
	    member2.printMemberAttribute();
	    System.out.println();
	    member3.printMemberAttribute();
	    
	    System.out.println();
	
	    System.out.println(member);//car 객체의 주소 출력
	    System.out.println(member2);//car2 객체의 주소 출력
	    System.out.println(member3);//car3 객체의 주소 출력
	 }
}