package test;

import java.util.Comparator;

public class MemberSecond implements Comparator<Member> {
	// 이름 순으로 오름차순 정렬
	
    @Override
    public int compare(Member o1, Member o2){
    	return o2.id.compareTo(o1.id);
    }
 }

