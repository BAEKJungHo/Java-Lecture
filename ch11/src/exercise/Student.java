package exercise;

public class Student {
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return studentNum;
	}

	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}

	 @Override
	 public boolean equals(Object obj) { // Method Signature
	 if(obj instanceof Student) { // Casting시 instanceof사용
	   Student st = (Student)obj; // 부모 --> 자식
	   if(studentNum.equals(st.studentNum)) { // equals()로 필드값 비교
	     return true;
	   }
	 }
	 return false;
	}
	
}
