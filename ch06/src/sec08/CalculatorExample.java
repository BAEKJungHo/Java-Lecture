package sec08;

public class CalculatorExample {
	public static void main(String[] args) {
		double result1 = 10 * 10 * Calculator.PI;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		Calculator cal = new Calculator();
		cal.setColor("red");
		
		System.out.println(cal.color);
	}
}
