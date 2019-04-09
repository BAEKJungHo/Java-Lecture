package sec01;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		// 동명이인
		set.add(new Member("홍길동", "M", "010-1234-5678"));
		set.add(new Member("홍길동", "M", "010-5678-1234"));
		
		System.out.println("총 객체 수 : " + set.size());
	}
}
