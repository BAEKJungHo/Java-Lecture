package bank;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scan = new Scanner(System.in);
	private static int createCount = 0;
	
	// Create Account
	private static void createAccount() {
		String ano;
		String owner;
		
		System.out.print("계좌번호를 입력하세요");
		ano = scan.nextLine();
		System.out.print("이름을 입력하세요 : ");
		owner = scan.nextLine();
	
		// Initialize balance ZERO
		accountArray[createCount] = new Account(ano, owner, 0);
		createCount++;
	}
	
	// Show list 
	private static void accountList() {
		for(int i=0; i<createCount; i++) {
			System.out.println(i + "번째 계좌 : " + accountArray[i].getAno());
		}
	}
	
	// Deposit
	private static void deposit() {
		System.out.print("입금할 계좌 번호를 입력하세요 : ");
		String account = scan.nextLine();
		
		System.out.print("입금 금액을 입력하세요 : ");
		findAccount(account).setBalance(Integer.parseInt(scan.nextLine()));
		
		System.out.println("입금된 금액 : " + findAccount(account).getBalance());
	}
	
	// Withdraw
	private static void withdraw() {
		int withdrawMoney = 0;
		System.out.print("출금할 계좌 번호를 입력하세요 : ");
		String account = scan.nextLine();
		
		System.out.println("출금 금액을 입력하세요");
		withdrawMoney = Integer.parseInt(scan.nextLine());
		
		findAccount(account).setBalance(findAccount(account).getBalance()-withdrawMoney); 
		
		System.out.println("출금한 금액 : " + withdrawMoney);
		System.out.println("남은 잔고 : " + findAccount(account).getBalance());
	}
	
	// Account 배열에서 ano와 동일한 Account 객체 찾기
	@SuppressWarnings("unlikely-arg-type")
	private static Account findAccount(String ano) {
		int checkNumber = 0;
		for(int i=0; i<createCount; i++) {
			if(ano.equals(accountArray[i].getAno())) 
				checkNumber = i;
		}
		
		return accountArray[checkNumber];
	}

	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1.계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료 ");
			System.out.println("-------------------------------------------------------");
			System.out.print("선택>");
			
			int selectNo = Integer.parseInt(scan.nextLine());
			
			if(selectNo == 1) {
				createAccount();
			} else if(selectNo == 2) {
				accountList();
			} else if(selectNo == 3) {
				deposit();
			} else if(selectNo == 4) {
				withdraw();
			} else if(selectNo == 5) {
				run = false;
			} else if(selectNo == 6) {
				accountList();
			}
		}
		System.out.println("프로그램 종료");
	}

}
