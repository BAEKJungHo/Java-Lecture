package basic02;

// DTO : Data Transfer Object (데이터 전송, 전달, 이동 객체) 
// song테이블에 대한 DTO 자료구조
public class SongDTO {
	
	private int id;
	private String title;
	private String lyrics;
	
	public SongDTO() { }
	
	public SongDTO(String title, String lyrics) {
		super();
		this.title = title;
		this.lyrics = lyrics;
	}
	
	public SongDTO(int id, String title, String lyrics) {
		super();
		this.id = id;
		this.title = title;
		this.lyrics = lyrics;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	@Override
	public String toString() {
		return "SongDTO [id=" + id + ", title=" + title + ", lyrics=" + lyrics + "]";
	}
}