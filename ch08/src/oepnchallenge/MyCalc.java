package oepnchallenge;

public class MyCalc implements Calculator {
	private int sum = 0;
	private int sub = 0;
	private int mul = 0;
	
	public void add(int a, int b) {
		this.sum = a + b;
		System.out.println(this.sum);
	}
	
	public void subtract(int a, int b) {
		if(a >= b) {
			this.sub = a - b;
			System.out.println(this.sub);
		}
		else {
			this.sub = b - a;
			System.out.println(this.sub);
		}
	}
	
	public void multiply(int a, int b) {
		this.mul = a * b;
		System.out.println(this.mul);
	}
}
