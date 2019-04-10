package sec02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSNS", "손오공"));
		messageQueue.offer(new Message("sendKAKAO", "사오정"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail" :
				System.out.println(message.to + "님에게 메일을 보냅니다");
				break;
			case "sendSNS" :
				System.out.println(message.to + "님에게 sns를 보냅니다");
				break;
			case "sendKAKAO" :
				System.out.println(message.to + "님에게 카톡을 보냅니다");
				break;
			}
		}

	}
}
