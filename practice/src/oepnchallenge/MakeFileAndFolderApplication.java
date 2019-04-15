package oepnchallenge;

import java.io.*;
import java.util.Random;

public class MakeFileAndFolderApplication {
	
	public static void main(String[] args) {
		

	}
	
	public static void mkfile() throws Exception {
		Random random1 = new Random();
		int content = random1.nextInt(3)+1;
		int title = random1.nextInt(10000);
	
		File file = new File(String.valueOf(title));
		FileWriter fw = new FileWriter(file, true);
		fw.write(String.valueOf(content));

	}
	
	public static void mkdir() throws Exception {
		String lowStr = "C:\\temp\\low"; 
		String midStr = "C:\\temp\\mid"; 
		String highStr = "C:\\temp\\high"; 
		File low = new File(lowStr);
		File mid = new File(midStr);
		File high = new File(highStr);
		
		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!low.exists()) {
			try{
			     low.mkdir(); //폴더 생성합니다.
			     System.out.println("폴더가 생성되었습니다.");
		     } 
		     catch(Exception e){
		    	 e.getStackTrace();
			}        
	    } else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
	}
}
