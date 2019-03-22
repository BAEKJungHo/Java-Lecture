package oepnchallenge;

public class MyMultiImpl implements MyMulti {
	private int maxNumber = 0;
	private int minNumber = 0;
	private int sum = 0;
	private double avg = 0.0;
	
	public int max(int[] array) {
		for(int i=0; i<array.length; i++) {
			if(array[i] > this.maxNumber) {
				this.maxNumber = array[i];
			}
		}
		return this.maxNumber;
	}
	
	public int min(int[] array) {
		this.minNumber = array[0];
		for(int i=0; i<array.length; i++) {
			if(array[i] < this.minNumber) {
				this.minNumber = array[i];
			}
		}
		return this.minNumber;
	}
	
	public int sum(int[] array) {
		for(int arrays : array) {
			this.sum += arrays;
		}
		return this.sum;
	}
	
	public double avg(int[] array) {
		return this.sum / array.length;
	}
}
