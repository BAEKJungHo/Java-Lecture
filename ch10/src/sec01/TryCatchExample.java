package sec01;

public class TryCatchExample {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("java");
		} catch(ClassNotFoundException e) {
			System.out.println("don't exsist");
		}

	}
}
