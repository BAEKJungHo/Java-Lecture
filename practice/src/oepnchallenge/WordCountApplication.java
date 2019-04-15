package oepnchallenge;

import java.io.*;
import java.util.*;

public class WordCountApplication {
	public static void main(String[] args) throws Exception {
		String filePath = "D:\\Workspace\\Egovernment\\Java\\practice\\src\\lyrics.txt";
		BufferedReader br = new BufferedReader(new FileReader(filePath)); 
        String line = "";
        StringTokenizer st;
        
        TreeSet<Word> treeSet = new TreeSet<Word>(new Comparator<Word>() {
        	@Override
    		public int compare(Word w1, Word w2) {
				if(w1.key.compareTo(w2.key) > 0) return 1;
				else if(w1.key.compareTo(w2.key) < 0) return -1;
				else return 0;
        	}
        }); 
        
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        while((line = br.readLine()) != null) {
        	st = new StringTokenizer(line, ".| |,");
        	for(int i=0; i<st.countTokens(); i++) {
        		String word = st.nextToken();
        		if(map.containsKey(word)) {
        			int value = map.get(word) + 1; // 중복 될 경우 value값 1증가
        			map.put(word, value);
        		} else { 
        			map.put(word, 1);
        		}
        	}
        }
        
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet) {
        	treeSet.add(new Word(entry.getKey(), entry.getValue()));
        }
        
        for(Map.Entry<String, Integer> entry : entrySet) {
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }

	}
}
