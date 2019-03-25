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
			// �����Ͻÿ� �� ��ġ�� method1Field2�� �����
			// �����Ͻÿ� �� ��ġ�� arg2�� �����
			String localField1;
			public void localMethod() { 
				sum = arg1 + method1Field1;
				System.out.println(sum + "&" + arg2);
				// �����Ͻÿ� �� ��ġ�� methodField1�� �����
				// �����Ͻÿ� �� ��ġ�� arg1�� �����
			}
		}
		// ���ø��Ŭ���� ��ü ����
		LocalMemberClass lClass = new LocalMemberClass();
		lClass.localMethod();
		System.out.println(arg1 +","+ arg2);
	}
	
	static public void method2() { }
	
	// Instance-Member-Class 
	class InstanceMemberClass {
		// Instance-Member-Class  ���ο��� OuterClass�� ��� �ʵ�� �޼ҵ忡 ���� ����
		
		String instanceField1 = "pill";
		int intanceField2;
		// static int instanceField3; (X)
		// static public void instanceMethod() { } (X)
		public void instanceMethod1() { }
		public void instanceMethod2() {
			System.out.println(this.instanceField1); // ��ø��ü�ʵ�����
			this.instanceMethod1(); // ��ø��ü�޼ҵ����� 
			
			System.out.println(OutterClass.this.field1); // �ٱ�Ŭ�����ʵ�����
			OutterClass.this.method1(10, "Mike"); // �ٱ�Ŭ�����޼ҵ� ����
		}
	}
	
	// Static-Member-Class
	static class StaticMemberClass {
		// Static-Member-Class ���ο����� OuterClass�� static�� ���� �ʵ�� �޼ҵ常 ���ٰ���
		
		static int staticField1;
		int staticField2;
		
		// field1�� Ŭ���� �ʵ尡 �ƴϹǷ� ���� �Ұ���
		// int staticField3 = OutterClass.this.field1; (X)
		
		static public void staticMethod1() { }
		public void staticMethod2() { }
	}
}
