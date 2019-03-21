package sec11;

public class InstanceofExample {
	
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	
	public static void method2(Parent parent) {
		Child child = (Child) parent;
		System.out.println("success");
	}
	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB = new Parent();
		method1(parentB);

	}
}
