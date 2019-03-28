package exam12;

public class SumAndMean {
	public static void main(String[] args) {
		int[][] intArray = {
				{95, 86, 88},
				{88, 92, 96, 85},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		double avg = 0.0;
		
		for(int i=0; i<3; i++) {
			for(int k=0; k<=i+2; k++) {
				sum += intArray[i][k];
			}
			avg = (double)sum/(intArray[i].length);
		}
		System.out.println("합 : " + sum + "평균 : " + avg);

	}
}
