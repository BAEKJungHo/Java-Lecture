package sec02;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample3 {
	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("C:/temp/test.txt");
		String data = "Hello Java Programming";
		writer.write(data);
		writer.flush();
		writer.close();
	}
}
