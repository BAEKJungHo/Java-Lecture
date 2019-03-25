package Openchallenge;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NumberOverlapCheckExercise {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		List<String> str = new ArrayList<>();
		
		boolean[] result = new boolean[10];
		
		for(int i=0; i<10; i++) {
			System.out.print(i + "번째 숫자를 입력하세요(최대 9자리까지 가능) : ");
			str.add(scan.nextLine());
			String array = str.get(i);
			int length = array.length();
			
			for(int k=0; k<length-1; k++) {
				for(int p=k+1; p<length; p++) {
					if(str.get(i).substring(k, k+1).equals(str.get(i).substring(p, p+1))) {
						result[i] = true;
					}
				}
			}
			System.out.println(result[i]);
		}
	}
}

/*
 public class Ex03CheckDuplicate {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbers = new String[10];
		boolean[] results = new boolean[10];
		
		for (int i=0; i<10; i++) {
			System.out.print("숫자 입력: ");
			String str = scan.nextLine();
			numbers[i] = str;
			if (i != 0) {
				boolean found = false;
				for (int k=0; k<i; k++) {
					if (str.equals(numbers[k])) {
						found = true;
						break;
					}
				}
				results[i] = found ? false : true;
			} else {
				results[0] = true;
			}
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(results));
	}
} */
 
