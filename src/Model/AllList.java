package Model;

import java.util.ArrayList;

import InterfaceOfModel.*;

public class AllList implements InterfaceOfAllList{
	private ArrayList<WordList> wordLists;
	private int right = 0;
	private int recite = 0; // the recited words 
	private int total; // denote the total number of words 
	private String [] listName = {"n", "v", "adv", "adj", "num", "prep", "pron", "int", "conj", "v.aux"};

	public AllList() {
		wordLists = new ArrayList<WordList>();
	}

	// initialize wordLists with the specific number
	public AllList(int number) {
		// to do
		initialize(number);
	}
	
	// initialize from the allWords at the first use time
	public void initializeFirst(int number, ArrayList<InterfaceOfWord> allWords) {
		// use allwords to construct wordLists
		for (int i = 0; i < number; i++) {
			WordList wordList = new WordList(i);
			this.addWordList(wordList);
		}
		for (int i = 0; i < allWords.size(); i++) {
			System.out.println(allWords.size());
			this.addWord(allWords.get(i));
			
		}
		Word word1 = new Word("can", "v.aux.能，会，可以", 9);
		Word word2 = new Word("will", "v.aux.将，愿", 9);
		this.addWord(word1);
		this.addWord(word2);
		writeAllList(number, this);
		calculateTotal();
	}

	// initialze from the exist file
	public void initialize(int number) {
		this.wordLists = new ArrayList(number);
		for (int i = 0; i < number; i++) {
			WordList wordList = new WordList(i);
			wordList.readWordList();
			wordLists.add(wordList);
		}
		calculateTotal();
		calculateRight();
		calculateRecite();
	}

	// write every wordlist to corresponding file
	public void writeAllList(int number, InterfaceOfAllList alllist) {
		for (int i = 0; i < number; i++) {
			// write to each document
			((AllList)alllist).wordLists.get(i).writeWordList();
		}
	}

	public int getRight() {
		this.calculateRight();
		return right;
	}

	public int getRecite() {
		this.calculateRecite();
		return recite;
	}

	public int getTotal() {
		this.calculateTotal();
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
		total=0;
		for (int i = 0; i < wordLists.size(); i++) {
			WordList wordList = wordLists.get(i);
			total += wordList.getSize();

		}

	}

	// get through the arraylist and choose the word recited and return an
	// arraylist of recited wordlist
	public void calculateRecite() {
		//ArrayList<WordList> recitedList = new ArrayList<WordList>();
		recite=0;
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
		right=0;
		for (int i = 0; i < wordLists.size(); i++) {
			WordList wordList = wordLists.get(i);
			right += wordList.getRight();

		}

	}

	// add a new wordList to the arraylist
	public void addWordList(InterfaceOfWordList wordList) {
		wordLists.add((WordList) wordList);
	}

	// add a new word to the arraylist
	public void addWord(InterfaceOfWord word) {
		int list = word.getWordList();
		wordLists.get(list).addWord(word);
	}

	// get the ith wordList
	public InterfaceOfWordList getWordList(int i) {
		return this.wordLists.get(i);
	}
	public String getListName(int n){
		return this.listName[n];
	}
	public boolean equals(Object b){
		AllList allList = (AllList)b;
		for (int i=0; i<this.wordLists.size(); i++){
			if	(!this.wordLists.get(i).equals(allList.wordLists.get(i)))
				return false;
		}
		return true;
	}
}
