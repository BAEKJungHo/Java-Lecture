package oepnchallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class WordCountApplication {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 파일명: ");
		String filePath = scan.nextLine();
		scan.close();
		
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		// 파일에서 읽어서 wordMap에 저장
		int count = 0;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, ",. ?!()");
			while (st.hasMoreTokens()) {
				count++;
				String word = st.nextToken();
				if (wordMap.containsKey(word)) {
					int val = wordMap.get(word);
					wordMap.put(word, val+1);
				} else {
					wordMap.put(word, 1);
				}
			}
		}
		System.out.println("총 단어수 = " + count);
		// wordMap에 저장되어 있는 데이터를 Top 10을 뽑기 위해 wordSet(TreeSet)에 저장
		count = 0;
		TreeSet<Word> wordSet = new TreeSet<Word>();
		Set<Map.Entry<String,Integer>> wordMapSet = wordMap.entrySet();
		for (Map.Entry<String,Integer> entry : wordMapSet) {
			wordSet.add(new Word(entry.getKey(), entry.getValue()));
			count++;
		}
		System.out.println("총 단어 종류 = " + count);
		
		// wordSet 내용중 10개만 출력
		count = 1;
		for (Word word: wordSet) {
			System.out.println(word.toString());
			if (count++ == 10)
				break;
		}
		br.close();
		fr.close();
	}

}