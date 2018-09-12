package rhymes;

import java.util.ArrayList;

import rhymes.dictionary.RhymingDictionary;

public class GameModel {
	private int score;
	private String referenceWord;
	private RhymingDictionary dictionary;
	private ArrayList<String> choices;

	public GameModel(String word) {
		this.dictionary = new RhymingDictionary(word);
		this.score = 0;
		this.referenceWord = dictionary.randomWord();
		this.choices = dictionary.getChoices(this.referenceWord);
	}

	public void makeChoice(String choice) {
		if (dictionary.isRhyme(choice, getGivenWord())) {
			this.score = getScore() + 1;
		} else {
			this.score = getScore() - 1;
		}
		this.referenceWord = dictionary.randomWord();
		this.choices = dictionary.getChoices(this.referenceWord);
	}

	public int getScore() {
		return this.score;
	}

	public String getGivenWord() {
		return this.referenceWord;
	}

	public ArrayList<String> getChoices() {
		return this.choices;
	}
}
