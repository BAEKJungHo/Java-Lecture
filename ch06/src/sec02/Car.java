package sec02;

public class Car {

	String company = "현대";
	String model = "그랜저";
	String color = "검정";
	protected int maxSpeed = 350; // 동일패키지 내에서만 접근 가능
	private int speed; // private 자기 클래스 내에서만 사용 가능
	
	public int getSpeed(int i) {
		this.speed = i;
		return this.speed;
	}
}
