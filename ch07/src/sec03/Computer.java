package sec03;

public class Computer extends Calculator {
	
	@Override
	double areaCircle(double r) {
		System.out.println("실행");
		return Math.PI * r * r;
	}

}
