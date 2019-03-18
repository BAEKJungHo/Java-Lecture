package sec01;

public class ArrayCreate {
	public static void main(String[] args) {
		int[] scores = { 83, 90, 87 };
		
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		
		int sum = 0;
		for(int score : scores) {
			sum += score;
		}
		System.out.println("합 : " + sum);
		double avg = (double) sum / scores.length;
		System.out.println("평균 : " + avg);

	}
}
