package practice01;

public class Basket {
	private String clothes;
	private int price;
	
	public Basket(String clothes, int price) {
		this.clothes = clothes;
		this.price = price;
	}

	public String getClothes() {
		return clothes;
	}

	public void setClothes(String clothes) {
		this.clothes = clothes;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
