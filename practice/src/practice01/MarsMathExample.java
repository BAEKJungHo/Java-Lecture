package practice01;

import java.util.Scanner;
import java.util.StringTokenizer;
public class MarsMathExample {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("테스트 케이스 숫자 입력 : ");
		int testCaseNumber = Integer.parseInt(scan.nextLine());
		
		String[] exp = new String[testCaseNumber];
		int[] expNum = new int[testCaseNumber];
		String[] expStr = new String[testCaseNumber];
		int[] result = new int[testCaseNumber];
		
		for(int i=0; i<testCaseNumber; i++) {
			System.out.print("식을 입력하세요");
			exp[i] = scan.nextLine();
			StringTokenizer st = new StringTokenizer(exp[i], " ");
			expNum[i] = Integer.parseInt(st.nextToken());
			int sum = 0;
			while(st.hasMoreTokens()) {
				try {
					for(int k=0; k<st.countTokens(); k++) {
						expStr[k] = st.nextToken();
						switch(expStr[k]) {
						case "@":
							sum += expNum[i] *3;
							break;
						case "%":
							sum += expNum[i] +5;
							break;
						case "#":
							sum += expNum[i] -7;
							break;
						default :
							break;
						}
						sum -= expNum[i];
					}
					result[i] = sum + expNum[i];
				} catch(NumberFormatException e) {
					e.printStackTrace();
				}
			}
		}
		for(int i=0; i<testCaseNumber; i++) {
			System.out.println(result[i]);
		}
	}
}
