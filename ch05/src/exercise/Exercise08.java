package exercise;

public class Exercise08 {
	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		int max = array[0][0], min = array[0][0];
		double varSub = 0.0;
		double avg = 0.0, variance = 0.0;

		for(int i=0; i<array[1].length; i++) {
			for(int k=0; k<array[i].length; k++) {
				// 합 구하기
				sum += array[i][k];
				
			}
		}
		
		// 평균 구하기
		avg = sum/(array[0].length + array[1].length + array[2].length);
		
		for(int i=0; i<array[1].length; i++) {
			for(int k=0; k<array[i].length; k++) {
				// 분산 구하기
				varSub += (array[i][k] - avg) * (array[i][k] - avg);
				
			}
		}
		
		variance = varSub/(array[0].length + array[1].length + array[2].length);
		
		
		for(int i=0; i<array[1].length; i++) {
			for(int k=0; k<array[i].length-1; k++) {
				// 최댓값, 최솟값 구하기
				if(array[i][k+1]> max) {
					max = array[i][k+1];
				}
				else if(array[i][k] < min) {
					min = array[i][k];
				}
				
			}
		}	
		
		System.out.println("SUM : " + sum);
		System.out.println("AVG : " + avg);
		System.out.println("MAX : " + max);
		System.out.println("MIN : " + min);
		System.out.println("VAR : " + variance);
	}
}
