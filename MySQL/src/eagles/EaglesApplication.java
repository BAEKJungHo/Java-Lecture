package eagles;

import java.util.List;
import java.util.Scanner;

public class EaglesApplication {

	public static void main(String[] args) {
		boolean run = true;
		
		int backNo;
		String name;
		String position;
		String hs;
		String hand;
		int birth;
		int salary;
		
		EaglesDTO eagles;
		List<EaglesDTO> playerList;
		EaglesDAO eDao = new EaglesDAO();
		
		while(run) {
			System.out.println("회원메뉴 1-선수등록, 2-조회, 3-트레이드 4-종료");
			Scanner scan = new Scanner(System.in);
			int number = Integer.parseInt(scan.nextLine());
			switch(number) {
			case 1: // 선수등록
				System.out.print("등번호>"); backNo = Integer.parseInt(scan.nextLine());
				System.out.print("이름>"); name = scan.nextLine();
				System.out.print("포지션>"); position = scan.nextLine();
				System.out.print("고등학교>"); hs = scan.nextLine();
				System.out.print("사용 손>"); hand = scan.nextLine();
				System.out.print("출생년도>"); birth = Integer.parseInt(scan.nextLine());
				System.out.print("연봉>"); salary = Integer.parseInt(scan.nextLine());
				
				eDao.insertPlayer(new EaglesDTO(backNo, name, position, hs, hand, birth, salary));
				System.out.println("입력 완료 !!");
				break;
			case 2: // 조회
				playerList = eDao.selectAll();
				for (EaglesDTO players : playerList) {
					System.out.println(players.toString());
				}
				break;
			case 3: // 트레이드
				System.out.print("트레이드할 등번호를 입력해 주세요 : ");
				int tradeBackNo = Integer.parseInt(scan.nextLine());
				System.out.println("== 새로운 선수의 정보를 입력해주세요 == ");
				System.out.print("등번호>"); backNo = Integer.parseInt(scan.nextLine());
				System.out.print("이름>"); name = scan.nextLine();
				System.out.print("포지션>"); position = scan.nextLine();
				System.out.print("고등학교>"); hs = scan.nextLine();
				System.out.print("사용 손>"); hand = scan.nextLine();
				System.out.print("출생년도>"); birth = Integer.parseInt(scan.nextLine());
				System.out.print("연봉>"); salary = Integer.parseInt(scan.nextLine());
				
				// Update 전
				System.out.println("변경 전");
				eagles = eDao.selectOne(tradeBackNo);
				System.out.println(eagles.toString());
				
				eagles.setBackNo(backNo);
				eagles.setName(name);
				eagles.setPosition(position);
				eagles.setHs(hs);
				eagles.setHand(hand);
				eagles.setBirth(birth);
				eagles.setSalary(salary);
				eDao.updatePlayer(eagles, tradeBackNo);
				
				// Update 후
				System.out.println("변경 후");
				eagles = eDao.selectOne(eagles.getBackNo());
				System.out.println(eagles.toString());
				break;
			case 4:
				System.out.println("종료되었습니다!");
				run = false;
				break;
			} // End of switch
		} // End of while
		
		// Connection close
		eDao.close();
	}
}