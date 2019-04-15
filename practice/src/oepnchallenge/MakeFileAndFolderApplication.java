package oepnchallenge;

import java.io.*;
import java.util.Random;

public class MakeFileAndFolderApplication {
	
	public static void main(String[] args) throws Exception {
		mkdirs();
		String fileName = null;
		for (int i=0; i<100; i++) {
			int numFile = (int)(Math.random() * 9000) + 1000;
			int numContent = (int)(Math.random() * 3) + 1;
			if (numFile <= 3333) {
				fileName = "c:/Temp/Ex04/low/" + numContent + "/" + numFile + ".txt";
			} else if (numFile <= 6666) {
				fileName = "c:/Temp/Ex04/mid/" + numContent + "/" + numFile + ".txt";
			} else {
				fileName = "c:/Temp/Ex04/high/" + numContent + "/" + numFile + ".txt";
			}
			FileOutputStream fos = new FileOutputStream(fileName);
			int content = (int)'0' + numContent;
			fos.write(content);
			fos.flush();
			fos.close();
		}
	}
	
	static void mkdirs() {
		File file = new File("c:/Temp/Ex04/low/1");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/low/2");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/low/3");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/mid/1");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/mid/2");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/mid/3");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/high/1");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/high/2");
		file.mkdirs();
		file = new File("c:/Temp/Ex04/high/3");
		file.mkdirs();
	}
}
