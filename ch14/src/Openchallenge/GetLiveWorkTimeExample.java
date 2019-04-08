package Openchallenge;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class GetLiveWorkTimeExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("시간을 입력하세요(HH:mm:ss) : ");
		String currentTime = scan.nextLine();
		
		try {
			SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
			
			Date date1 = format1.parse("18:30:00");
			Date date2 = format1.parse(currentTime);
			long diff = date1.getTime() - date2.getTime();

			String time1 = format1.format(diff-3600*1000*9);
			System.out.println("퇴근까지 남은 시간 : " + time1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
