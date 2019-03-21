package exercise1;

public class SongLyrics extends Song {
	
	private String lyrics;
	
	public SongLyrics(String title, String artist, String album, String composer, int year, int track, String lyrics) {
		super(title, artist, album, composer, year, track);
		this.lyrics = lyrics;
	}
	
	@Override
	public void show() {
		System.out.println("Song [title=" + title + ", artist=" + artist + ", album=" + album + ", composer=" + composer + ", year="
				+ year + ", track=" + track + ", lyrics=" + lyrics + "]");
	}
	
}
