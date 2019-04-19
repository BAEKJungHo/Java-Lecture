package city;

import java.util.List;
import java.util.Scanner;

public class CityApplication {
	public static void main(String[] args) {
		boolean run = true;
		
		List<CityDTO> cityList;
		CityDAO cDao = new CityDAO();
		
		while(run) {
			System.out.println("메뉴 1-조회 2-종료");
			Scanner scan = new Scanner(System.in);
			int number = Integer.parseInt(scan.nextLine());
			switch(number) {
			case 1: // SelectAll
				cityList = cDao.selectAll();
				for (CityDTO cities : cityList) {
					System.out.println(cities.toString());
				}
				break;
			case 2:
				System.out.println("종료되었습니다!");
				run = false;
				break;
			} // End of switch
		} // End of while
		
		// Connection close
		cDao.close();
	}
}