package sec08;

public class CarTest {
	int speed;
	
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}
	
	public static void main(String[] args) {
		CarTest car = new CarTest();
		car.speed = 80;
		car.run();

	}

}
