package sec01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample3 {
	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/temp/test.txt");
		byte[] data = "HELLO".getBytes();
		os.write(data, 1, 2);
		os.flush();
		os.close();
	}
}