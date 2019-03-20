package openchallenge;

public class Sub {

	private int a;
	private int b;
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate() {
		if(a>b)
			return a-b;
		else
			return b-a;
	}
}
