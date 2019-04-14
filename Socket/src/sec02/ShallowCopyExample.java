package sec02;

import java.util.ArrayList;
import java.util.List;

public class ShallowCopyExample {
	public static void main(String[] args) {
		String str1 = "Java";
		String copyStr1 = str1;
		
		System.out.println("-----------------------값 확인----------------------");
		
		System.out.println("Original : " + str1 + "   -----   " + "Copy : " + copyStr1);
		
		String str2 = new String("Maven");
		String copyStr2 = str2;
		
		System.out.println("Original : " + str2 + "   -----   " + "Copy : " + copyStr2);
		
		int[] array1 = new int[] {1, 2, 3, 4, 5};
		int[] copyArray = array1;
		
		System.out.print("Original : ");
		for(int array : array1) {
			System.out.print(array);
		}
		
		System.out.print("   -----   ");
		
		System.out.print("Copy : ");
		for(int array : copyArray) {
			System.out.print(array);
		}
		
		System.out.println();
		
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("Python");
		
		List<String> copyList = list;
		
		System.out.print("Original : ");
		for(String str : list) {
			System.out.print(str);
		}
		
		System.out.print("   -----   ");
		
		System.out.print("Copy : ");
		for(String str : copyList) {
			System.out.print(str);
		}
		System.out.println(); System.out.println();
		System.out.println("-----------------------메모리 번지 확인----------------------");
		System.out.println("Str1 :" + str1.hashCode());
		System.out.println("copyStr1 :" + copyStr1.hashCode());
		System.out.println("Str2 :" + str2.hashCode());
		System.out.println("copyStr2 :" + copyStr2.hashCode());
		System.out.println("array :" + array1.hashCode());
		System.out.println("copyArray :" + copyArray.hashCode());
		System.out.println("list :" + list.hashCode());
		System.out.println("copyList :" + copyList.hashCode());
		
		System.out.println();
		
		// 복제한 copyList에 문자열 추가
		copyList.add("Spring");
		System.out.println("list :" + list);
		System.out.println("copyList :" + copyList);

	}
}
