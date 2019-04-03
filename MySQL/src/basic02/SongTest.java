package basic02;

import java.util.List;

public class SongTest {
	public static void main(String[] args) {
		// SongDAO 객체를 생성하면서 JDBC 드라이버 로딩 완료
		SongDAO sDao = new SongDAO();
		
		// sDao.insertSong(new SongDTO("빨간맛", "빠빠빨간 맛 궁금해 허니"));
		//SongDTO sDto = new SongDTO("빨간맛", "빠빠빨간 맛 궁금해 허니");
		// sDao.insertSong(sDto);
		
		//SongDTO sDto = sDao.selectOne(117);
		/*SongDTO sDto = sDao.selectOne(118);
		System.out.println(sDto.toString() + "\n");
		sDto.setTitle("넌 이즈 뭔들");
		sDto.setLyrics("나 지금 너 땜에 혼라스러 제발 누가 나 좀 말려줘");
		sDao.updateSong(sDto);
		sDto = sDao.selectOne(118);
		System.out.println(sDto.toString() + "\n");
		
		sDao.deleteSong(sDto);*/
		
		List<SongDTO> list = sDao.selectAll();
		for (SongDTO song : list) {
			System.out.println(song.toString());
		}
		sDao.close();
	}
}