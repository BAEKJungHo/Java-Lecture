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
		int offset = 0;
		byte[] b = new byte[16];
		int len; // 실제로 읽어온 길이 (바이트 개수)
		int count = 0;
		while((len = in.read(b)) > 0) {
			System.out.printf("%08X:  ", offset); // 앞을 0으로채우고 8자리의 16진수로 출력
	
		    for (int i=0; i<len; i++) {
		      if (i == 8) System.out.print(" ");    
		      System.out.printf("%02X ", b[i]); 
		    }
	
		    for (int i=0; i<=(16 - len) * 3; i++)
		      System.out.print(" ");
		    if (len < 9) System.out.print(" "); 
	
		    for (int i=0; i<len; i++) {
		    	if (b[i] >= 0x20 && b[i] <= 0x7E) // 특수 문자가 아닐 경우 출력
		    		System.out.print((char)b[i]);
		    	else System.out.print("."); // 특수문자, 그래픽문자 등은 마침표로 출력
		    }
		    offset += 16;
		    System.out.println();
		} // End of while
		if (offset == 0) System.out.printf("%08X:  ", offset); // 0byte 파일인 경우 처리
		in.close();
	}
}

