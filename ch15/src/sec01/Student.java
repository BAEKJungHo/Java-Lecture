package sec01;

public class Student {
	
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student) {
			Student student = (Student)o;
			return name.equals(student.name);
		} else return false;
	}
	
	@Override
	public int hashCode() {
		return sno;
	}
}
