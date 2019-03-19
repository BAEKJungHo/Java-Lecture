package exercise;

public class StudentScore {
	
	String name;
	int math;
	int english;
	int science;
	double avg;
	
	public StudentScore(String name, int math, int english, int science){
		this.name = name;
		this.math = math;
		this.english = english;
		this.science = science;
	}
	
	double average() {
		this.avg = (math+english+science) / 3.0;
		return avg;
	}

	@Override
	public String toString() {
		return "StudentScore [name=" + name + ", math=" + math + ", english=" + english + ", science=" + science
				+ ", avg=" + avg + "]";
	}
	
	
}
