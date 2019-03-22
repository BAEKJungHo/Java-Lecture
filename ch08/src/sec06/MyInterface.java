package sec06;

public interface MyInterface {

	public void method1();
	
	public default void method2() {
		System.out.println("2 실행");
	}
}
