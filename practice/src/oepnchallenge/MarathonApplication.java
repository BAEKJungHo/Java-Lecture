package oepnchallenge;

import java.util.*;

public class MarathonApplication {
	public static void main(String[] args) {
		List<String> participants = new ArrayList<String>(); // 참가자 
		
		participants.add("홍길동"); participants.add("홍길동"); participants.add("홍길동");
		participants.add("손오공"); participants.add("저팔계"); participants.add("사오정");
		participants.add("손오공"); participants.add("신용재"); participants.add("신용재");
		participants.add("윤민수"); participants.add("류재현"); participants.add("양다일");
		
		System.out.print("참가자 : ");
		for(String str : participants) {
			System.out.print(" " + str);
		}
		System.out.println();
		
		complete(participants);

	}
	
	public static void complete(List<String> list) {
		Random random = new Random();
		int fail = random.nextInt(12)+1;
		List<String> completioners = new ArrayList<String>();
		// List 복사를 위해 addAll()사용
		completioners.addAll(list);
		System.out.println("미완주 : " + completioners.get(fail));
		completioners.remove(fail);
		
		System.out.print("완주 : ");
		for(String str : completioners) {
			System.out.print(" " + str);
		}
	}
}
