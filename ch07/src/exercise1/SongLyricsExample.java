package exercise1;

public class SongLyricsExample {
	public static void main(String[] args) {
		String[] composer = new String[100];

		SongLyrics songLyrics = new SongLyrics("Love of My Life", "Queen", "Bohemian Rhapsody", composer , 2018, 10,
				"Love of my life,\r\n" + 
						"You hurt me,\r\n" + 
						"You broken my heart,\r\n" + 
						"Now you leave me");
		
		songLyrics.show();

	}
}
