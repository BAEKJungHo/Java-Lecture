package sec02;

public class MemberApplication {
	public static void main(String[] args) throws CloneNotSupportedException {
	    Member member = new Member(26, 10001, "John", "���� ����", "Developer");
	
	    // member��ü�� �� ���� ���� member2��ü�� �� ������ ����
	    Member member2 = (Member) member.clone(); // Shallow Copy
	
	    Member member3 = member.copy(); // copy()�޼ҵ忡�� ����ȯ�� �̸� ���༭ ���� �ʿ� ����
	
	    member.printMemberAttribute();
	    System.out.println();
	    member2.printMemberAttribute();
	    System.out.println();
	    member3.printMemberAttribute();
	    
	    System.out.println();
	
	    System.out.println(member);//car ��ü�� �ּ� ���
	    System.out.println(member2);//car2 ��ü�� �ּ� ���
	    System.out.println(member3);//car3 ��ü�� �ּ� ���
	 }
}