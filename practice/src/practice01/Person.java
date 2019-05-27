package practice01;

public class Person {
	
	private String name;
	String str;
	
	public Person(String name, String test) {
		this.name = name;
		str = test;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String test) {
		str = test;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", str=" + str + "]";
	}	
}
