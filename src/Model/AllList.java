package Model;

import java.util.ArrayList;

public class AllList {
	private ArrayList<WordList> wordLists;
	private int right = 0;
	private int recite = 0; // the recited words 
	private int total; // denote the total number of words 

	public AllList() {
		wordLists = new ArrayList<WordList>();
	}

	// initialize wordLists with the specific number
	public AllList(int number) {
		// to do
		for (int i = 0; i < number; i++) {
			WordList wordList = new WordList(i);
			this.addWordList(wordList);
		}
	}

	// initialize from the allWords at the first use time
	void initializeFirst(int number, ArrayList<Word> allWords) {
		// use allwords to construct wordLists
		for (int i = 0; i < number; i++) {
			WordList wordList = new WordList(i);
			this.addWordList(wordList);
		}
		for (int i = 0; i < allWords.size(); i++) {
			this.addWord(allWords.get(i));
		}
		writeAllList(number, this);
		calculateTotal();
	}

	// initialze from the exist file
	void initialize(int number) {
		wordLists = new ArrayList<WordList>(number);
		IO io = new IO();
		for (int i = 0; i < number; i++) {
			WordList wordList = new WordList().readWordList();
			wordLists.set(i, wordList);
		}
		calculateTotal();
		calculateRight();
		calculateRecite();
	}

	// write every wordlist to corresponding file
	void writeAllList(int number, AllList alllist) {
		for (int i = 0; i < number; i++) {
			// write to each document
			alllist.wordLists.get(i).writeWordList();
		}
	}

	int getRight() {
		return right;
	}

	int getRecite() {
		return recite;
	}

	int getTotal() {
		return total;
	}

	void setRecite(int recite) {
		this.recite = recite;
	}

	void setTotal(int total) {
		this.total = total;
	}

	// get through the arraylist and add the total number of words
	void calculateTotal() {
		for (int i = 0; i < wordLists.size(); i++) {
			WordList wordList = wordLists.get(i);
			total += wordList.getSize();

		}

	}

	// get through the arraylist and choose the word recited and return an
	// arraylist of recited wordlist
	void calculateRecite() {
		//ArrayList<WordList> recitedList = new ArrayList<WordList>();
		for (int i = 0; i < wordLists.size(); i++) {
			WordList wordList = wordLists.get(i);
			if (wordList.getRecite() > 0) {
				recite += wordList.getRecite();
				//recitedList.add(wordList);
			}

		}
		//return recitedList;
	}

	// get through the arraylist and choose the word right
	void calculateRight() {
		for (int i = 0; i < wordLists.size(); i++) {
			WordList wordList = wordLists.get(i);
			right += wordList.getRight();

		}

	}

	// add a new wordList to the arraylist
	void addWordList(WordList wordList) {
		wordLists.add(wordList);
	}

	// add a new word to the arraylist
	void addWord(Word word) {
		int list = word.getWordList();
		wordLists.get(list).addWord(word);
	}

	// get the ith wordList
	WordList getWordList(int i) {
		return this.wordLists.get(i);
	}
	// get the record array.
	int[] getRecord(int wordList){
		int result[] = {this.total, this.recite, this.right};
		return result;
	}
}
