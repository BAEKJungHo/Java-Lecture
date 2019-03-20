package getter;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setSpeed(80);
		
		if(!myCar.isStop()) {
			myCar.setStop(true);
		}

		System.out.println(myCar.getSpeed());
	}
}
