package sec05;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {
		IntSupplier supplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};
		int num = supplier.getAsInt();
		System.out.println(num);

	}
}
