package sec01;

public class RemoteControlExample {
	public static void main(String[] args) {
		
		SmartTelevision tv = new SmartTelevision();
		
		Searchable sc = tv;
		RemoteControl rc = tv;
		
		sc.search("naver");
		rc.setVolume(110);

	}

}
