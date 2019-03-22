package sec04;

public class Driver {

	public void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFar();
		}
		vehicle.run();
	}
}
