package exercise;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public static List<Board> getBoardList() {
		Board board1 = new Board("제목1", "내용1");
		Board board2 = new Board("제목2", "내용2");
		Board board3 = new Board("제목3", "내용3");
		List<Board> list = new ArrayList<>(); // 컬렉션 생성
		
		list.add(board1);
		list.add(board2);
		list.add(board3);
		
		return list;
	}
}
