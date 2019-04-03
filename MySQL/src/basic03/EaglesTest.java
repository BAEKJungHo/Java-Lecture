package basic03;

import java.util.List;

import basic02.SongDTO;

public class EaglesTest {
	public static void main(String[] args) {
		EaglesDAO eDao = new EaglesDAO();
	/*
		eDao.insertPlayer(new EaglesDTO(11, "윤민수", "외야수", "대전고", "우투", 1998, 800000000));
		EaglesDTO player = eDao.selectOne(11);
		System.out.println(player.toString() + "\n");
		eDao.deletePlayer(11);
	*/
	/*
		// Update 전
		EaglesDTO player = eDao.selectOne(10);
		System.out.println(player.toString());
		
		player.setPosition("투수");
		player.setSalary(880000000);
		eDao.updatePlayer(player);
		
		// Update 후
		player = eDao.selectOne(10);
		System.out.println(player.toString());
	*/
		String positions[] = {"투수", "포수", "내야수", "외야수"};
		for(String position : positions) {
			List<EaglesDTO> playerList = eDao.selectPlayersByPosition(position);
			System.out.println("포지션이 " + position + "인 선수 명단");
			for (EaglesDTO players : playerList) {
				System.out.println(players.toString());
			}
			System.out.println();
		}
		System.out.println("연봉 2억원 이상 선수 명단");
		List<EaglesDTO> playerList = eDao.selectPlayersBySalary(20000000);
		for (EaglesDTO players : playerList) {
			System.out.println(players.toString());
		}
		
	/*
		System.out.println("======================외야수==========================");
		// selectAll
		List<EaglesDTO> list = eDao.selectPlayersByPosition("외야수");
		for (EaglesDTO players : list) {
			System.out.println(players.toString());
		}
	*/
		// close
		eDao.close();
	}
}
