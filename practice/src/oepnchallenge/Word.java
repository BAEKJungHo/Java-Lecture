package oepnchallenge;

public class Word {

	public String key;
	public int value;
	
	Word(String key, int value) {
		this.key = key;
		this.value = value;
	}
	Word(String key) {
		this.key = key;
	}
	Word(int value) {
		this.value = value;
	}
}
