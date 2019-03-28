package newOpenChallenge;

public class PythagorasExample {
	public static void main(String[] args) {
		
		int pythagorasA = 0;
		int pythagorasB = 0;
		int pythagorasC = 0;
		
		for(int a=1; a<500; a++) {
			for(int b=a+1; b<500; b++) {
				pythagorasC = 1000 - a - b;
				if((b<pythagorasC) && (a<pythagorasC)) {
					if((a+b) > pythagorasC) {
						if(((a*a+b*b) == pythagorasC*pythagorasC) && ((a+b+pythagorasC) == 1000)){
							pythagorasA = a;
							pythagorasB = b;
						}
					}
				}
			}
		}
		pythagorasC = 1000 - pythagorasA - pythagorasB;
		System.out.println(pythagorasA + ", " + pythagorasB + ", " + pythagorasC);
	}
}