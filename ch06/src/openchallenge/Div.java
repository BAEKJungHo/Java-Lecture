package openchallenge;

public class Div {

	private int a;
	private int b;
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate() {
		int ifDiv = 0;
		int elseDiv = 0;
		try {
			if(a>b)
				ifDiv = a/b;
			else 
				elseDiv = b/a;
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누면 안됨");
		}
		
		return ifDiv+elseDiv;
	}
}
