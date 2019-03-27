package exercise;

import java.util.regex.Pattern;

public class PatternMatcherExample {
	public static void main(String[] args) {
		String id = "5Angel1004";
		String regExp = "[a-z][A-Z]\\w{8,12}";
		boolean isMatch = Pattern.matches(regExp, id);
		if(isMatch) {
			System.out.println("id로 사용 가능");
		} else {
			System.out.println("id로 사용 불가능");
		}

	}
}
