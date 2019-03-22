package sec07;

public interface ChildInterface2 extends ParentInterface {
	@Override
	public default void method2() {
		System.out.println("start");
	}
	public void method3();

}
