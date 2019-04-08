package sec04;

public class UsingThis {
	
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method() {
			MyFunctionalInterface fi = () -> {
				System.out.println(outterField);
				System.out.println(UsingThis.this.outterField);
				System.out.println(innerField);
				System.out.println(this.innerField);
			};
			fi.method();
		}
	}
}
