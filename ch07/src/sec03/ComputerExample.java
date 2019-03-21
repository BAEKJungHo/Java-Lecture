package sec03;

public class ComputerExample {
	public static void main(String[] args) {
		int r = 10;
		
		Calculator cal = new Calculator();
		System.out.println(cal.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println(computer.areaCircle(r));

	}
}
