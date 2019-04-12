package oepnchallenge;

public class MySortApp {
	public static void main(String[] args) {
		MySort mysort = null;
		mysort = new MySortImpl();
		
		String[] array = new String[] {"김길동", "박길동", "이길동", "홍길동", "정길동"};
		
		for(String osc : mysort.sort(array)) {
			System.out.print(osc + " ");
		}
		
		System.out.println();
		
		for(String desc : mysort.sort(array, true)) {
			System.out.print(desc + " ");
		}
	}
}
