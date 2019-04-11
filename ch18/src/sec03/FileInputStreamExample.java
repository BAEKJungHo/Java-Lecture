package sec03;

import java.io.FileInputStream;

public class FileInputStreamExample {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:\\Workspace\\Egovernment\\Java\\ch18\\src\\sec03\\FileInputStreamExample.java");
			int data;
			while((data = fis.read()) != -1) {
				System.out.write(data);
			}
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
