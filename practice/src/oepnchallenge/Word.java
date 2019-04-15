package oepnchallenge;

public class Word implements Comparable<Word> {
	private String word;
	private int count;
	
	public Word() { }
	public Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(Word w) {
		if (count < w.getCount()) return 1;
		if (count > w.getCount()) return -1;
		return word.compareTo(w.getWord());
	}
	@Override
	public String toString() {
		return "[word=" + word + ", count=" + count + "]";
	}
}