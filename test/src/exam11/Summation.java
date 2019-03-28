package exam11;

public class Summation {
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i=0; i<=1000; i=i+7) {
			sum += i;
		}
		System.out.println(sum);

	}
}
