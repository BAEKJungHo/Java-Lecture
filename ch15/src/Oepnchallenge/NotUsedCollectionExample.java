package Oepnchallenge;

import java.util.Arrays;
import java.util.StringTokenizer;

public class NotUsedCollectionExample {
	
	public static void main(String[] args) {
		String name = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,"
				+ "박민호,전경헌,송정환,김재성,이유덕,이재영,전경헌";
		
		eliDuplicatedString(name);
	}
	
	public static void eliDuplicatedString(String argName) {
		int countLee = 0;
		int countKim = 0;
		int countLeeJaeYoung = 0;
		int duplicatedCount = 0;
		
		StringTokenizer st = new StringTokenizer(argName, ",");
		int countToken = st.countTokens();
		
		String[] names = new String[countToken];
		String[] notDuplicatedName;
		
		System.out.print("초기 : ");
		for(int i=0; i<countToken; i++) {
			names[i] = st.nextToken();
			System.out.print(" "+ names[i]);
		}
		System.out.println();
			
		for(int i=0; i<names.length; i++) {
			// 이씨 김씨 구하기
			if(names[i].substring(0, 1).equals("이")) {
				countLee++;
			} else if(names[i].substring(0, 1).equals("김")) {
				countKim++;
			}
			
			// 이재영 찾기 
			if(names[i].equals("이재영")) {
				countLeeJaeYoung++;
			}
		}
		
		System.out.println("이씨 : " + countLee + "명");
		System.out.println("김씨 : " + countKim + "명");
		System.out.println("이재영 중복 횟수 : " + countLeeJaeYoung);
		
		// 중복된 이름 제거
		for(int i=0; i<names.length-1; i++) {
			for(int k=i+1; k<names.length; k++) {
				if(names[i].equals(names[k]) && !names[i].equals("Duplicated") && !names[k].equals("Duplicated")) {
					names[k] = "Duplicated";
					duplicatedCount++;
				}
			}
		}
		
		int p = 0;
		notDuplicatedName = new String[names.length-duplicatedCount];
		// 중복안된 이름 배열에 저장
		for(int i=0; i<names.length; i++) {
			if(!names[i].equals("Duplicated")) {
				notDuplicatedName[p] = names[i];
				p++;
			}
		}
		
		System.out.println("중복된 이름 제거 : " + Arrays.toString(notDuplicatedName));
		
		// 중복 제거한 이름 오름 차순 정렬 
		for(int i=0; i<notDuplicatedName.length; i++) {
			String temp;
			for(int k=0; k<notDuplicatedName.length-1; k++) {
				if(notDuplicatedName[k].compareTo(notDuplicatedName[k+1]) > 0) {
					temp = notDuplicatedName[k];
					notDuplicatedName[k] = notDuplicatedName[k+1];
					notDuplicatedName[k+1] = temp;
				}
			}
		}
		System.out.println("오름차순 정렬 : " + Arrays.toString(notDuplicatedName));
	}
}
