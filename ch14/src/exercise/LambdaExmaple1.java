package exercise;

import java.util.function.ToIntFunction;

public class LambdaExmaple1 {

	private static Student[] students = {
			new Student("홍길동", 90, 96),
			new Student("손오공", 95, 93)
	};
	
	public static double avg(ToIntFunction<Student> function) {
		int sum = 0;
		for(Student student : students) {
			sum += function.applyAsInt(student);
		}
		double avg = (double)sum/students.length;
		return avg;
	}
	
	public static void main(String[] args) {
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println(englishAvg);
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println(mathAvg);
	}

}