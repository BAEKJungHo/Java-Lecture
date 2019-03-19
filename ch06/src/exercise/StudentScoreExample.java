package exercise;

import java.util.Scanner;
public class StudentScoreExample {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 | 수학 | 영어 | 과학");
		
		String name = scan.nextLine();
		int math = scan.nextInt();
		int english = scan.nextInt();
		int science = scan.nextInt();
		double avg;
		
		StudentScore student1 = new StudentScore(name, math, english, science);
		avg = student1.average();
		System.out.println(student1.toString());

	}
}
