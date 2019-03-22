package sec06;

public class DefaultMethodExample {
	public static void main(String[] args) {
		
		MyInterface i1 = new MyClassA();
		i1.method1();
		i1.method2();
		
		MyInterface i2 = new MyClassB();
		i2.method1();
		i2.method2();

	}

}
