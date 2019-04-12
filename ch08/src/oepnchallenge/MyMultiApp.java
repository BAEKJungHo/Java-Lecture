package oepnchallenge;

public class MyMultiApp {
	public static void main(String[] args) {
		MyMulti mymulti = null;
		
		mymulti = new MyMultiImpl();
		
		int[] array = new int[] {10, 20, 30, 40, 50}; 
		
		System.out.println(mymulti.max(array));
		System.out.println(mymulti.min(array));
		System.out.println(mymulti.sum(array));
		System.out.println(mymulti.avg(array));
	}
}
