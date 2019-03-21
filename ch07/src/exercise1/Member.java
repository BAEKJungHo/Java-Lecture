package exercise1;

public class Member extends Customer{
	private int memNumber;
	private int mileage;
	
	public Member(String name, String phoneNumber, String address, int memNumber, int mileage) {
		super(name, phoneNumber, address);
		this.memNumber = memNumber;
		this.mileage = mileage;
	}
	
	@Override
	public void show() {
		System.out.println("Customer [name=" + name + ", phoneNumber=" + phoneNumber 
				+ ", address=" + address + ", memNumber=" + memNumber + ", mileage=" + mileage + "]");
	}

}
