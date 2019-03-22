package exercise;

public class MysqlDao implements DataAccessObject {
	
	public void select() {
		System.out.println("Mysql DB에서 검색");
	}
	
	public void insert() {
		System.out.println("Mysql DB에 삽입");
	}
	
	public void update() {
		System.out.println("Mysql DB를 수정");
	}
	
	public void delete() {
		System.out.println("Mysql DB에서 삭제");
	}

}
