package sec05;
/*
public class Student {

	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student(String name, int englishScore, int mathScore) {
		super();
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}	
}

*/

public class Student {

	private String name;
	private String sex;
	private int score;
	
	public Student(String name, String sex, int score) {
		super();
		this.name = name;
		this.sex = sex;
		this.score = score;
	}

	public String getSex() {
		return sex;
	}

	public int getScore() {
		return score;
	}
	
}
