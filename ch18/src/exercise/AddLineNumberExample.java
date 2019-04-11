package exercise;

import java.io.*;

public class AddLineNumberExample {
	public static void main(String[] args) throws Exception {
		String filePath = "D:\\Workspace\\Egovernment\\Java\\ch18\\src\\exercise\\AddLineNumberExample.java";
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		
		String data;
		int lineNo = 0;
		while((data=br.readLine()) != null) {
			System.out.println(++lineNo + ": " + data);
		}
		br.close();
	}
}