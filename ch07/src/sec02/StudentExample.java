package sec02;

public class StudentExample {
	public static void main(String[] args) {
		Student student = new Student("백정호", "01089241810" , 1);
		System.out.println(student.name);
		System.out.println(student.ssn);
		System.out.println(student.studentNo);
	}
}
