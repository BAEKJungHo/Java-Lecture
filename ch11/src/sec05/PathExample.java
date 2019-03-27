package sec05;

import java.util.StringTokenizer;
public class PathExample {
	public static void main(String[] args) {
		String path = System.getenv("path");
		StringTokenizer st = new StringTokenizer(path, ";");
		
		int count = st.countTokens();
		for(int i=0; i<count; i++) {
			String str = st.nextToken();
			System.out.println(str);
		}
	}
}
