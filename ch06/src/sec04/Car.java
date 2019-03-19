package sec04;

public class Car {

	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// defualt Constructor
	Car() {
		
	}
	
	Car(String model){
		this.model = model;
	}
	
	Car(String model, String color){
		//this.model = model;
		//this.color = color;
		this(model, color, 0);
	}
	
	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
}
