package Openchallenge;

public class PythagorasExample {
	public static void main(String[] args) {
		
		int pythagorasA = 0;
		int pythagorasB = 0;
		int pythagorasC = 0;
		
		for(int a=1; a<800; a++) {
			for(int b=a+1; b<800; b++) {
				for(int c=b+1; c<800; c++) {
					if((a<b) && (b<c) && (a<c)) {
						if((a+b) > c) {
							if(((a*a+b*b) == c*c) && ((a+b+c) == 1000)){
								pythagorasA = a;
								pythagorasB = b;
								pythagorasC = c;
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(pythagorasA + ", " + pythagorasB + ", " + pythagorasC);

	}
}
