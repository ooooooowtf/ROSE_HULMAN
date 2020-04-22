import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Links implements LinksInterface {
	private File file;
	private HashMap<String, HashSet<String>> wordMap;
	private HashSet<String> words;
	public Links(String fileName) {
		this.file = new File(fileName);
		this.wordMap = new HashMap<>();// Stores candidates
		this.words = new HashSet<>();// Checks for bad words
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} // Creates a scanner that reads for potential candidates.
		
		while (sc.hasNextLine()) {
			String word = sc.nextLine();
			wordMap.put(word, new HashSet<String>());
			words.add(word);
		}
		
		for (String w : wordMap.keySet()) {
			for (String w2 : wordMap.keySet()) {
				if (isCandidate(w, w2)) // Checks to see if the word diff is off by 1
					wordMap.get(w).add(w2);
			}
		}
	}

	private boolean isCandidate(String word1, String word2) {
		if (word1.length() != word2.length())
			return false;

		int diffCount = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				diffCount++;// Makes the comparison.
			if (diffCount > 1)
				return false;
		}
		return diffCount == 1;
	}

	@Override
	public Set<String> getCandidates(String word) {
		if (!words.contains(word))
			return null;
		if (this.wordMap.get(word).isEmpty()) 
			return null;
			
		return this.wordMap.get(word);
	}

	@Override
	public boolean exists(String word) {
		return words.contains(word);
	}

}
