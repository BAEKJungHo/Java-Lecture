package sec04;

public class StringCharAtExample {
	public static void main(String[] args) {
		String ssn = "940502-1010110";
		char sex = ssn.charAt(7);
		switch(sex) {
		case '1' :
		case '3' :
			System.out.println("Male");
			break;
		case '2' :
		case '4' :
			System.out.println("Female");
			break;
		}

	}
}
