package openchallenge;

import java.io.*;
import java.util.Scanner;
public class HexaDump {
	
	public static void main(String[] args) throws Exception {
		// D:\Workspace\Egovernment\Java\ch18\bin\openchallenge\\HexaDump.class
		Scanner scan = new Scanner(System.in);
		System.out.println("찾을 파일명 :");
		String filePath = scan.nextLine();
		
		DataInputStream in = new DataInputStream(new FileInputStream(filePath));
	
		byte[] b = new byte[1024];
		int len; // 실제로 읽어온 길이 (바이트 개수)
		
		while((len = in.read(b)) > 0) {
	      for (int i = 0; i < len; i++) { // byte[] 버퍼 내용 출력
		        System.out.format("%02X ", b[i]);
		  }
		}
		
	}
}
