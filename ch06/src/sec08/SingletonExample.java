package sec08;

public class SingletonExample {
	public static void main(String[] args) {

		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) 
			System.out.println("서로 같습니다.");
		else 
			System.out.println("서로 다릅니다.");

	}
}
