package exercise;

public class Student {

	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student) {
			Student student = (Student)o;
			return this.studentNum == student.studentNum;
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return studentNum;
	}
}
