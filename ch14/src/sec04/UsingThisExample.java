package sec04;

public class UsingThisExample {
	public static void main(String[] args) {
		UsingThis ut = new UsingThis();
		UsingThis.Inner inner = ut.new Inner();
		inner.method();
	}
}
