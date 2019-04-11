package sec02;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample2 {
	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("C:/temp/test.txt");
		int readCharNo;
		char[] cbuf = new char[4];
		String data = "";
		while(true) {
			readCharNo = reader.read(cbuf);
		
		}
	}

}
