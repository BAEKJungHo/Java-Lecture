package exercise;

import java.util.Scanner;

public class Exercise09 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		int max, sum = 0;
		double avg = 0.0;
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1.학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("------------------------------------------------------------");
			System.out.print("선택>");
			
			int selectNo = scan.nextInt();
			
			if(selectNo == 1) {
				System.out.print("학생 수>");
				studentNum = scan.nextInt();
				scores = new int[studentNum];
				
			}
			else if(selectNo == 2) {
				for(int i=0; i<studentNum; i++) {
					System.out.print("scores[" + i + "]> ");
					scores[i] = scan.nextInt();
				}
			}
			else if(selectNo == 3) {
				for(int i=0; i<studentNum; i++) {
					System.out.println("scores[" + i + "]" + scores[i]);
				}
			}
			else if(selectNo == 4) {
				max = scores[0];
				for(int i=0; i<scores.length; i++) {
					if(scores[i] > max) {
						max = scores[i];
					}
					sum += scores[i];
				}
				avg = sum / scores.length;
				System.out.println("최고점수 : " + max);
				System.out.println("평균점수 : " + avg);
			}
			else if(selectNo == 5) {
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
		
		scan.close();

	}
}
