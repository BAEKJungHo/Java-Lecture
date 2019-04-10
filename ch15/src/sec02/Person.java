package sec02;

public class Person implements Comparable<Person> {

	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override 
	public int compareTo(Person o) {
		if(age > o.age) return 1;
		else if(age == o.age) 
			return name.compareTo(o.name);
		else return -1;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Person) {
			Person person = (Person)o;
			return name.equals(person.name);
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return age;
	}
	
	
}
