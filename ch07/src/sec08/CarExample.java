package sec08;

import sec07.HankookTire;
import sec07.KumhoTire;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run();
			if(problemLocation%2 != 0) {
				System.out.println(car.tires[problemLocation-1].location + "Hankook");
				car.tires[problemLocation-1] = new HankookTire(car.tires[problemLocation-1].location, 15);
			}
			else {
				System.out.println(car.tires[problemLocation-1].location + "Kumhoo");
				car.tires[problemLocation-1] = new KumhoTire(car.tires[problemLocation-1].location, 15);
			}
			System.out.println("---------------------");
		}

	}

}
