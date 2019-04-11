package openchallenge;

import java.io.*;
import java.util.Scanner;

public class GrepApplication {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("찾을 문자열 : ");
		String findStr = scan.nextLine();
		System.out.println("찾을 파일명 :");
		String filePath = scan.nextLine();
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
	
		
		String data;
		int lineNo = 0;
		while((data=br.readLine()) != null) {
			if(data.indexOf(findStr) > -1) 
				System.out.println(++lineNo + ": " + data);
			else 
				continue;
		}
		br.close();
	}
}
