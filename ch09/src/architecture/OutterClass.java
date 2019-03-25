package architecture;

public class OutterClass {
	
	String field1 = "dope";
	int field2; 
	
	static int field3;
	
	public void method1(final int arg1, String arg2) {
		final int method1Field1 = 10;
		String methodField2 = null;
		
		// Local-Member-Class
		class LocalMemberClass {
			int sum = 0;
			// 컴파일시에 이 위치에 method1Field2이 복사됨
			// 컴파일시에 이 위치에 arg2가 복사됨
			String localField1;
			public void localMethod() { 
				sum = arg1 + method1Field1;
				System.out.println(sum + "&" + arg2);
				// 컴파일시에 이 위치에 methodField1이 복사됨
				// 컴파일시에 이 위치에 arg1이 복사됨
			}
		}
		// 로컬멤버클래스 객체 생성
		LocalMemberClass lClass = new LocalMemberClass();
		lClass.localMethod();
		System.out.println(arg1 +","+ arg2);
	}
	
	static public void method2() { }
	
	// Instance-Member-Class 
	class InstanceMemberClass {
		// Instance-Member-Class  내부에선 OuterClass의 모든 필드와 메소드에 접근 가능
		
		String instanceField1 = "pill";
		int intanceField2;
		// static int instanceField3; (X)
		// static public void instanceMethod() { } (X)
		public void instanceMethod1() { }
		public void instanceMethod2() {
			System.out.println(this.instanceField1); // 중첩객체필드참조
			this.instanceMethod1(); // 중첩객체메소드참조 
			
			System.out.println(OutterClass.this.field1); // 바깥클래스필드참조
			OutterClass.this.method1(10, "Mike"); // 바깥클래스메소드 참조
		}
	}
	
	// Static-Member-Class
	static class StaticMemberClass {
		// Static-Member-Class 내부에서는 OuterClass의 static이 붙은 필드와 메소드만 접근가능
		
		static int staticField1;
		int staticField2;
		
		// field1은 클래스 필드가 아니므로 접근 불가능
		// int staticField3 = OutterClass.this.field1; (X)
		
		static public void staticMethod1() { }
		public void staticMethod2() { }
	}
}
