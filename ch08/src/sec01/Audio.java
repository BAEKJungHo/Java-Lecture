package sec01;

public class Audio implements RemoteControl {
	
	private int volume;
	private boolean mute;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다");
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
	
	@Override 
	public void setMute(boolean mute) {
		this.mute = mute;
		if(mute) {
			System.out.println("audio 무음처리");
		}else {
			System.out.println("audi 무음해제");
		}
	}

}
