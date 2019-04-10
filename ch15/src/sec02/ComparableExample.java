package sec02;

import java.util.TreeSet;

public class ComparableExample {
	public static void main(String[] args) {
		
		TreeSet<Person> treeSet = new TreeSet<Person>();
		
		Person p1 = new Person("홍길동", 50);
		Person p2 = new Person("홍길동", 50);
		
		if(p1.equals(p2)) System.out.println("true");
		
		treeSet.add(new Person("홍길동", 10));
		treeSet.add(new Person("길동이", 20));
		treeSet.add(new Person("동동이", 30));
		treeSet.add(new Person("홍길동", 20));
		
		for(Person person : treeSet) {
			System.out.println(person.name + " : " + person.age);
		}

	}
}
