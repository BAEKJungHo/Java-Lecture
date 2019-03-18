package exercise;

import java.util.Scanner;
public class OpenChallenge {
	public static void main(String[] args) {
		int row, col;
		int leftCount = 0, rightCount = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("행을 입력하세요");
		row = Integer.parseInt(scan.nextLine());
		
		System.out.print("열을 입력하세요");
		col = Integer.parseInt(scan.nextLine());
		
		int[][] left = new int[row][col];
		int[][] right = new int[col][row];
		int[][] merge = null;
		
		// left Array Input value
		for(int i=0; i<row; i++) {
			for(int k=0; k<col; k++) {
				System.out.println(++leftCount +"번째 left array값을 입력하세요");
				left[i][k] = Integer.parseInt(scan.nextLine());
			}
		}
		
		// right Array Input value
		for(int i=0; i<col; i++) {
			for(int k=0; k<row; k++) {
				System.out.println(++rightCount +"번째 right array값을 입력하세요");
				right[i][k] = Integer.parseInt(scan.nextLine());
			}
		}
		merge = new int[row][col];
		// Matrix Multiplication
		for(int i=0; i<row; i++) {
			for(int k=0; k<row; k++) {
				int sum = 0;
				for(int p=0; p<col; p++) {
					sum += left[i][p]*right[p][k];
				}
				merge[i][k] = sum;
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int k=0; k<row; k++) {
				System.out.print(merge[i][k]);
				System.out.println();
			}
		}
	}
}
