package Exercise;

import java.util.Scanner;
public class Exercise07 {
	public static void main(String[] args) throws Exception{
		boolean run = true;
		
		int balance = 0;
		int num = 0;
		String str = "";
		
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------");
			System.out.print("선택>");
			str = sc.nextLine();
			if(str.equals("1")) {
				System.out.print("예금액>");
				num = Integer.parseInt(sc.nextLine());
				balance += num;
				System.out.println("현재 잔고 : " + balance);
			}
			else if(str.equals("2")) {
				System.out.print("출금액>");
				num = Integer.parseInt(sc.nextLine());
				if(num > balance) {
					System.out.println("잔고보다 출금액이 많습니다.");
					continue;
				}
				else balance -= num;
				
				System.out.println("현재 잔고 : " + balance);
			}
			else if(str.equals("3")) {
				System.out.println("잔고>" + balance);
			}
			else if(str.equals("4")) {
				run = false;
			}
			
		}
		System.out.println("exit");
		sc.close();
	}
}
