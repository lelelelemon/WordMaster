package Model;

import java.util.ArrayList;

import InterfaceOfModel.InterfaceOfAllList;
import InterfaceOfModel.InterfaceOfWordList;

public class AllList implements InterfaceOfAllList{
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
	public void initializeFirst(int number, ArrayList<Word> allWords) {
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
	public void initialize(int number) {
		IO io = new IO();
		for (int i = 0; i < number; i++) {
			String filename = i + ".txt";
			WordList wordList = io.read(filename);
			this.addWordList(wordList);
		}
		calculateTotal();
		calculateRight();
		calculateRecite();
	}

	// write every wordlist to corresponding file
	public void writeAllList(int number, AllList alllist) {
		for (int i = 0; i < number; i++) {
			// write to each document
			alllist.wordLists.get(i).writeWordList();
		}
	}

	public int getRight() {
		return right;
	}

	public int getRecite() {
		return recite;
	}

	public int getTotal() {
		return total;
	}

	public void setRecite(int recite) {
		this.recite = recite;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// get through the arraylist and add the total number of words
	public void calculateTotal() {
		for (int i = 0; i < wordLists.size(); i++) {
			WordList wordList = wordLists.get(i);
			total += wordList.getSize();

		}

	}

	// get through the arraylist and choose the word recited and return an
	// arraylist of recited wordlist
	public void calculateRecite() {
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
	public void calculateRight() {
		for (int i = 0; i < wordLists.size(); i++) {
			WordList wordList = wordLists.get(i);
			right += wordList.getRight();

		}

	}

	// add a new wordList to the arraylist
	public void addWordList(WordList wordList) {
		wordLists.add(wordList);
	}

	// add a new word to the arraylist
	public void addWord(Word word) {
		int list = word.getWordList();
		wordLists.get(list).addWord(word);
	}

	// get the ith wordList
	public InterfaceOfWordList getWordList(int i) {
		return this.wordLists.get(i);
	}
	// get the record array.
	public int[] getRecord(int wordList){
		int[] result = new int[3];
		if(wordList == -1){
			result[0] = this.total;
			result[1] = this.recite;
			result[2] = this.right;
		}
		else{
			WordList list = (WordList) this.getWordList(wordList);
			result[0] = list.getSize();
			result[1] = list.getRecite();
			result[2] = list.getRight();
		}
		return result;
	}
}
