package exam14;

public class Student extends Person {
	
	private int id;
	private String name;
	private int score;
	
	Student(int id, String name, int score){
		this.id = id;
		this.name = name;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student)obj;
			if((id == student.id) && (name.equals(student.name))) {
				return true;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return id + name.hashCode();
	}

}
