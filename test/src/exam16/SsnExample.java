package exam16;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;
public class SsnExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// While문 빠져나오기 위한 변수
		boolean run = true;
		
		StringBuilder sbDate = new StringBuilder();
		StringBuilder sbSex = new StringBuilder();
		
		// StringBuilder 안에 있는 문자열을 옮겨 담을 변수
		String date = null;
		String sex = null;
		
		// 성별판단을 위한 변수
		boolean isSex;
		
		while(run) {
			System.out.print("입력 : ");
			
			String ssn = scan.nextLine();
			StringTokenizer st = new StringTokenizer(ssn, "-");
			
			sbDate.append(st.nextToken());
			sbSex.append(st.nextToken());
			
			date = sbDate.toString();
			sex = sbSex.toString();
			
			// boolean
			run = inputError(date, sex);
			isSex = genderCheck(sex);
			
			if((run == true) || (isSex == true) || (isSex == true)) {
				System.out.println("다시 입력하세요 !!");
				
				// StringBuilder 비우기
				sbDate.delete(0, date.length());
				sbSex.delete(0, sex.length());
				continue;
			}
		}
		
		// 맨앞 인덱스에 "20"추가해서 4자리 연도수 만들기
		sbDate.insert(0, "20"); 
		date = sbDate.toString();
		
		// 연도, 월, 일
		String year = date.substring(0, 4);
		String month = date.substring(4, 6);
		String day = date.substring(6, 8);
		
		// Java.time 패키지 사용
		LocalDate targetDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (E)");
		String calender = targetDate.format(dateTimeFormatter);
		
		// 성별
		String gender = "";
		
		if((Integer.valueOf(sex) == 2) || (Integer.valueOf(sex) == 4)) {
			gender = "여자";
		}
		else if((Integer.valueOf(sex) == 1) || (Integer.valueOf(sex) == 3)) {
			gender = "남자";
		}
		
		System.out.println("출력 : " + calender + ", " + gender);
		
		scan.close();
	}
	
	// 숫자로 변환 가능한지 판별하는 메소드
	public static boolean isStringInt(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }
	
	// 길이와 숫자변환이 안되는 경우
	public static boolean inputError(String d, String s) {
		// 입력된 길이 판별
		if((d.length() != 6) || (s.length() != 1)) {
			return true;
		}
		// 숫자변환가능여부 메소드 호출
		else if((isStringInt(d) != true) || (isStringInt(s) != true)) {
				return true;
		}	
		// 조건성립
		else if((d.length() == 6) || (s.length() == 1)){
			if((isStringInt(d) == true) || (isStringInt(s) == true)) {
				return false;
			 }
		}
		return false;
	}
	
	// 숫자는 맞지만 성별(1~4)이 다른경우
	public static boolean genderCheck(String g) {
		if(isStringInt(g) == true) {
			if((Integer.valueOf(g) >= 1) && Integer.valueOf(g) < 5) {
				return false;
			}
		} else {
			return true;
		}
		return false;
	}
}
