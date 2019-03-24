package architecture;

public class NestedClassTest {
	public static void main(String[] args) {
		OutterClass outter = new OutterClass();
		
		OutterClass.InstanceMemberClass iClass = outter.new InstanceMemberClass();
		OutterClass.StaticMemberClass sClass = new OutterClass.StaticMemberClass();

		outter.method1(8, "john");
		iClass.instanceMethod2();
	}
}
