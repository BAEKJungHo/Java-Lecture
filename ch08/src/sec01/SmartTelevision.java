package sec01;

public class SmartTelevision implements RemoteControl, Searchable {
	
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("on");
	}
	
	@Override
	public void turnOff() {
		System.out.println("off");
	}
	
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("Volume : " + this.volume);
	}
	
	public void search(String url) {
		System.out.println(url + "검색");
	}
	

}
