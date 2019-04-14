package sec01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try { 
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5003));
			// 반복으로 accept() 호출하여 다중 클라이언트 연결 수락
			while(true) {
				System.out.println("[Connection Waiting]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[Connection Accept]" + isa.getHostName());
			}
		} catch(Exception e) {}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch(IOException ee) {}
		}
	}
}