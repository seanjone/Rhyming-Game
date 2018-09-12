package rhymes.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RhymingDictionary {
	private String file;
	private HashMap<String, ArrayList<String>> rhymes;

	public RhymingDictionary(String file) {
		this.file = file;
		this.rhymes = new HashMap<>();
		parseDictionary();
	}

	public void parseDictionary() {
		try {
			for (String line : Files.readAllLines(Paths.get(this.file))) {
				ArrayList<String> pronunciation = new ArrayList<>();
				String[] temp = line.split("  ");
				String[] temp1 = temp[1].split(" ");
				for (int i = 0; i < temp1.length; i++) {
					pronunciation.add(temp1[i]);
				}
				this.rhymes.put(temp[0], pronunciation);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int lastVowel(ArrayList<String> pronunciation) {
		int num = 0;
		for (String segment : pronunciation) {
			if (segment.contains("0") || segment.contains("1") || segment.contains("2")) {
				num = pronunciation.lastIndexOf(segment);
			}
		}
		return num;
	}

	public boolean isRhyme(String word1, String word2) {
		String lastPronun1 = "";
		String lastPronun2 = "";
		String rhyme1 = word1.toUpperCase();
		String rhyme2 = word2.toUpperCase();
		int lastVowel1 = lastVowel(this.rhymes.get(rhyme1));
		int lastVowel2 = lastVowel(this.rhymes.get(rhyme2));
		if (this.rhymes.containsKey(rhyme1) && this.rhymes.containsKey(rhyme2)) {
			for (int i = lastVowel1; i < this.rhymes.get(rhyme1).size(); i++) {
				if (i == lastVowel1) {
					String woNum = this.rhymes.get(rhyme1).get(i).substring(0, 2);
					lastPronun1 = lastPronun1 + woNum;
				} else {
					lastPronun1 = lastPronun1 + this.rhymes.get(rhyme1).get(i);
				}
			}
			for (int i = lastVowel2; i < this.rhymes.get(rhyme2).size(); i++) {
				if (i == lastVowel2) {
					String woNum = this.rhymes.get(rhyme2).get(i).substring(0, 2);
					lastPronun2 = lastPronun2 + woNum;
				} else {
					lastPronun2 = lastPronun2 + this.rhymes.get(rhyme2).get(i);
				}
			}
		} else {
			return false;
		}
		if (lastPronun1.equalsIgnoreCase(lastPronun2)) {
			return true;
		} else {
			return false;
		}
	}

	public String randomWord() {
		ArrayList<String> allWords = new ArrayList<>();
		for (String word : this.rhymes.keySet()) {
			allWords.add(word);
		}
		Collections.shuffle(allWords);
		String randomWord = allWords.get(0);
		return randomWord;
	}

	public ArrayList<String> getChoices(String rhymingWord) {
		boolean rhymed = false;
		ArrayList<String> choices = new ArrayList<>();
		while (choices.size() < 4) {
			String potentialChoice = randomWord();
			if (isRhyme(potentialChoice, rhymingWord) && !rhymed && !potentialChoice.equals(rhymingWord)) {
				choices.add(potentialChoice);
				rhymed = true;
			} else if (!isRhyme(potentialChoice, rhymingWord) && rhymed) {
				choices.add(potentialChoice);
			}
		}
		Collections.shuffle(choices);
		return choices;
	}

}
