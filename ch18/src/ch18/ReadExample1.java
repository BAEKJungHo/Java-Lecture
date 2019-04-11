package ch18;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample1 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/temp/test.txt");
		int readByte;
		while(true) {
			readByte = is.read();
			if(readByte == -1) break;
			System.out.println(readByte);
		}
		is.close();
	}
}
