package sec02;

import java.util.Arrays;

public class BubbleSortExample {

	public static void main(String[] args) {
		String[] array = new String[] {"김", "이", "박"};
		//Arrays.sort(array);
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void bubbleSort(String[] names) {
		String temp;
		for(int i=0; i<names.length; i++) {
			for(int k=i+1; k<names.length-1; k++) {
				if(names[k].compareTo(names[k+1]) > 0) {
					temp = names[k];
					names[k] = names[k+1];
					names[k+1] = temp;
				}
			}
		}
	}
}