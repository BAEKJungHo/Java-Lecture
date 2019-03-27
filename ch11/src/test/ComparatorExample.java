package test;

import java.util.Arrays;

public class ComparatorExample {
    public static void main(String[] args) {
	  Member John = new Member("John");
	  Member Mike = new Member("Mike");
	  Member Ellis = new Member("Ellis");
	  
	  Member[] members = { John, Mike, Ellis };
	  
	  // Arrays.sort(객체배열변수, Comparator 규칙 객체)
	  Arrays.sort(members, new MemberSecond());
 
	  /*
	  for(int i=0; i<members.length; i++) {
		  System.out.println(members[i].id);
	  }
	  */
	  
	  for(Member names : members) {
		  System.out.println(names.id); // 객체.필드
	  }
	  
	  // 정렬 후 John의 Index는 1
	  int index = Arrays.binarySearch(members, John, new MemberSecond());
	  System.out.println(index);
      
    }
  }