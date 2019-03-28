package exam13;

import java.util.Arrays;
import java.util.Random;

public class LottoNumber {

	public static void main(String[] args) {
		int[] lottoArray = getLottoNumber();
		System.out.println(Arrays.toString(lottoArray));

	}
	
	static int[] getLottoNumber() {
		Random random = new Random();
		int[] selectNumber = new int[6];
		
		for(int i=0; i<selectNumber.length; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
		}
		return selectNumber;
		
	}
}
