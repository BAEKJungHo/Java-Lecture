package sec02;

public class Member implements Cloneable {
	private int age;// Member객체의 age 속성
	private int id;// Member객체의 id 속성
	private String name;// Member객체의 name 속성
	private String address;// Member객체의 address 속성
	private String job;// Member객체의 job 속성
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    return super.clone(); // 객체가 힙영역에 가지고 있는 값이 복사되지만 main에서 형변환을 해줘야한다
	}
	
	// Member 타입에 사용할 수 있는 copy()메소드 선언
	// 즉, main에서 형변환을 따로 해주지 않고 복제 할 수 있다.
	public Member copy() throws CloneNotSupportedException {
	     Member member = (Member)clone();
	    return member;
	}
	
	// getter와 setter대신에 생성자와 함수를 이용해서 값을 설정하고 출력
	public Member(int age, int id, String name, String address, String job) {
	    super();
	    this.age = age;
	    this.name = name;
	    this.id = id;
	    this.address = address;
	    this.job = job;
	}
	
	// 객체의 속성을 출력할 printCarAttribe 함수를 선언하고 정의
	public void printMemberAttribute() {
	    System.out.println("나이 : "+age);
	    System.out.println("ID : " +id);
	    System.out.println("이름 : "+name);
	    System.out.println("주소 : "+address);
	    System.out.println("직업 : "+job);
	 }
}