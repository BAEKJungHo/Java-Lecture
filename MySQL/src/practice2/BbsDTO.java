package practice2;

import java.sql.Timestamp;

public class BbsDTO {

	private int id;
	private int memberId;
	private String title;
	private Timestamp date;
	private String content;
	
	public BbsDTO(int id, int memberId, String title, Timestamp date, String content) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	
	public BbsDTO( ) { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BbsDTO [id=" + id + ", memberId=" + memberId + ", title=" + title + ", date=" + date + ", content="
				+ content + "]";
	}
}
