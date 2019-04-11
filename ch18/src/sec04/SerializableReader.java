package sec04;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializableReader {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassA v = (ClassA)ois.readObject();
		System.out.println(v.field1);
		System.out.println(v.field2.field1);
		System.out.println(v.field3);
		System.out.println(v.field4);

	}
}
