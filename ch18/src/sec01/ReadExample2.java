package sec01;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample2 {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/temp/test.txt");
		int readByteNo; 
		byte[] readBytes = new byte[3]; // 읽어드릴 배열의 크기 
		String data = "";
		while(true) {
			// 읽은 바이트들을 배열 readBytes에 저장하고 실제로 읽은 바이트 수를 리턴
			// 더이상 읽을 바이트가 없으면 -1 리턴
			readByteNo = is.read(readBytes);
			System.out.println(readByteNo);
			if(readByteNo == -1) break;
			data += new String(readBytes, 0, readByteNo);
		}
		System.out.println(data);
		is.close();
	}
}
