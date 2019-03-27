package sec05;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
		// 선택번호
		int[] selectNumber = new int[6]; // 선택번호 6개가 저장될 배열
		Random random = new Random();
		System.out.print("선택 번호 : ");
		for(int i=0; i<6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.println(selectNumber[i] + " ");
		}
		System.out.println();
		
		// 당첨번호
		int[] winningNumber = new int[6];
		random = new Random();
		System.out.println("당첨 번호 : ");
		for(int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.println("당첨 여부 : ");
		if(result) {
			System.out.println("1등");
		} else {
			System.out.println("x");
		}
		

	}
}
