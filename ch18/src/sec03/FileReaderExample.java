package sec03;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderExample {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader ("D:\\Workspace\\Egovernment\\Java\\ch18\\src\\sec03\\FileReaderExample.java");
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while(str != null) {
			System.out.println(str);
		}
		fr.close();
	}
}
