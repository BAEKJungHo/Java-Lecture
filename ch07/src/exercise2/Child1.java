package exercise2;

public class Child1 extends Parent1 {
	
	private String name;
	
	public Child1() {
		this("홍길동");
		System.out.println("cc");
	}
	
	public Child1(String name) {
		this.name = name;
		System.out.println("cc");
	}

}
