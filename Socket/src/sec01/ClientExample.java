package sec01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {
  public static void main(String[] args) {
    Socket socket = null;
    try {
      socket = new Socket(); // Socket ����
      System.out.println("[Connection Request]");
      socket.connect(new InetSocketAddress("localhost", 5003)); // ���� ��û
      // socket = new Socket("localhost", 5001);
      System.out.println("[Success Connection]");
    } catch(Exception e) {}

    if(!socket.isClosed()) {
      try {
        socket.close();
      } catch(IOException e) {}
    }
  }
}