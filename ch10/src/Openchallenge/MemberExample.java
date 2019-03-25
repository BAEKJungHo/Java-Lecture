package Openchallenge;

import java.util.Scanner;
public class MemberExample {
	public static void main(String[] args) {
	
		try {
			loginMember();
		} catch(InvalidLoginIdException e) {
			String message = e.getMessage();
			System.out.println(message);
		} catch(IncorrectPasswordException e) {
			String message = e.getMessage();
			System.out.println(message);
		}

	}
	
	public static void loginMember() throws InvalidLoginIdException, IncorrectPasswordException {
		Scanner scan = new Scanner(System.in);
	
		String[] loginIds = new String[] { "abcde", "fghij", "klmno", "pqrst", "uvwxyz" };
		String[] passwords = new String[] { "abcde12", "fghij12", "klmno12", "pqrst12", "uvwxyz12" };
		
		String inputID;
		String inputPW;
		String successMessage = null;
		
		System.out.print("아이디를 입력하세요 : ");
		inputID = scan.nextLine();
		System.out.println("패스워드를 입력하세요 : ");
		inputPW = scan.nextLine();
		
		for(int i=0; i<loginIds.length; i++) {
			if(inputID.equals(loginIds[i]) == inputPW.equals(passwords[i])) {
				if(inputID.equals(loginIds[i]) != false) {
					successMessage = "Success to Login";
					break;
				}
				else if(inputID.equals(loginIds[i]) == false) {
					successMessage = "패스워드와 아이디가 올바르지 않습니다";
					break;
				}
			} else if(!inputID.equals(loginIds[i])) {
				throw new InvalidLoginIdException("Not exist ID");
			} else if(!inputPW.equals(passwords[i])) {
				throw new IncorrectPasswordException("Not Correct PW");
			} 
		}
		
		if(successMessage.equals("Success to Login")) {
			System.out.println(successMessage);
		}
		else {
			System.out.println(successMessage);
		}
	}
}
