package Openchallenge;

public class Member implements Comparable<Member> {
	
	private String name;
	private String id;
	private String password;
	private int age;
	
	public Member(String name, String id, String password, int age) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
    @Override
    public int compareTo(Member o){
      // 문자열 크기비교 String클래스의 메소드 a.compareTo(b) > 0 사용
      if(this.age > o.age) return 1;
      else if(this.age == o.age) return 0;
      else return -1;
    }
    
}
