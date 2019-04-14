package sec02;

public class Member implements Cloneable {
	private int age;// Member��ü�� age �Ӽ�
	private int id;// Member��ü�� id �Ӽ�
	private String name;// Member��ü�� name �Ӽ�
	private String address;// Member��ü�� address �Ӽ�
	private String job;// Member��ü�� job �Ӽ�
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    return super.clone(); // ��ü�� �������� ������ �ִ� ���� ��������� main���� ����ȯ�� ������Ѵ�
	}
	
	// Member Ÿ�Կ� ����� �� �ִ� copy()�޼ҵ� ����
	// ��, main���� ����ȯ�� ���� ������ �ʰ� ���� �� �� �ִ�.
	public Member copy() throws CloneNotSupportedException {
	     Member member = (Member)clone();
	    return member;
	}
	
	// getter�� setter��ſ� �����ڿ� �Լ��� �̿��ؼ� ���� �����ϰ� ���
	public Member(int age, int id, String name, String address, String job) {
	    super();
	    this.age = age;
	    this.name = name;
	    this.id = id;
	    this.address = address;
	    this.job = job;
	}
	
	// ��ü�� �Ӽ��� ����� printCarAttribe �Լ��� �����ϰ� ����
	public void printMemberAttribute() {
	    System.out.println("���� : "+age);
	    System.out.println("ID : " +id);
	    System.out.println("�̸� : "+name);
	    System.out.println("�ּ� : "+address);
	    System.out.println("���� : "+job);
	 }
}