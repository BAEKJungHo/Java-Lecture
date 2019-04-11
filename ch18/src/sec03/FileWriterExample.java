package sec03;

import java.io.File;
import java.io.FileWriter;

public class FileWriterExample {
	public static void main(String[] args) throws Exception {
		File file = new File("C:/temp/test.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write("FileWriter는 한글로된 문자열을 바로 출력할 수있다.");
		fw.flush();
		fw.close();
		System.out.println("저장완료");

	}
}
