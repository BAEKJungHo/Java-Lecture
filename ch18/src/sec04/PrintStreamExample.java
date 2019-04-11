package sec04;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("C:/temp/test.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.println("프린터 보조 스트림");
		ps.println("마치");
		ps.println("프린터가 출력하는 것처럼 보임");
		
		ps.flush();
		ps.close();
		fos.close();
	}
}
