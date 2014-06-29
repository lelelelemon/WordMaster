package Model;

import java.util.ArrayList;

import InterfaceOfModel.*;

public class WordList implements InterfaceOfWordList {
	private ArrayList<Word> words;
	private int wordList;
	private int offset = 0; // the offset of the word recited to
	private int size = 0;// the size of the wordList
	private int right = 0;// the right number of recited words
	private int recite = 0;// the number of recited words
	private String fileName;// each WordList correspond to a file
	private String [] listName = {"n", "v", "adv", "adj", "num", "prep", "pron", "int", "conj", "v.aux"};
	public WordList() {
		words = new ArrayList<Word>();
	}

	public WordList(int i) {
		words = new ArrayList<Word>();
		this.wordList = i;
		this.fileName = i + ".txt";

	}

	public int getWordList() {
		return this.wordList;
	}

	public int getOffset() {
		return this.offset;
	}

	public int getSize() {
		this.size = this.words.size();
		return this.size;
	}

	public int getRight() {
		this.calculateRight();
		return this.right;
	}

	public int getRecite() {
		this.calculateRecite();
		return this.recite;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setWordList(int wordList) {
		this.fileName = wordList + ".txt";
		this.wordList = wordList;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void setRecite(int recite) {
		this.recite = recite;
	}

	// get through the arraylist and choose the word recited and return the
	// arraylist of all the recited words;
   public void calculateRecite() {
	   recite=0;
		//ArrayList<Word> recitedWords = new ArrayList<Word>();
		for (int i = 0; i < words.size(); i++) {
			Word word = words.get(i);
			if (word.getTotal() > 0) {
				recite++;
				//recitedWords.add(word);
			}
		}
		//return recitedWords;

	}

	// get through the arraylist and choose the word recited
	public void calculateRight() {
		right=0;
		for (int i = 0; i < words.size(); i++) {
			Word word = words.get(i);
			if (word.getRight() > 0) {
				right++;
			}
		}

	}

	// add a new word to the arraylist
	public void addWord(InterfaceOfWord word) {
		words.add((Word) word);
		word.setOffset(size);
		this.size++;
	}

	public InterfaceOfWordList readWordList() {
		IO io = new IO();
		WordList wl = (WordList) io.read(fileName);
		this.setOffset(wl.getOffset());
		this.words = wl.getWords();
		this.wordList = wl.getWordList();
		this.setSize(wl.getSize());
		return this;
	}

	public void writeWordList() {
		IO io = new IO();
		io.writeWordList(this);
	}
	// get next word
	public InterfaceOfWord getNextWord(){
		this.offset++;
		return this.words.get(this.offset - 1);
	}
	// get current word
	public InterfaceOfWord getCurWord(int i){
		return this.words.get(i);
	}
	
	ArrayList<Word> getWords(){
		return this.words;
	}
	
	public boolean equals(Object b){
		WordList wordList = (WordList)b;
		if	(!(wordList.getOffset()==offset))
			return false;
		if (!(wordList.getRecite()==recite))
			return false;
		if (!(wordList.getRight()==right))
			return false;
		if (!(wordList.getSize()==size))
			return false;
		if (!(wordList.getWordList()==this.wordList))
			return false;
		for (int i=0; i<size; i++){
			if (!(wordList.getCurWord(i).equals(getCurWord(i))))
				return false;
		}
		return true;
	}
	
	public String searchFirst(String first){
		for(int i = 0 ;i < this.size; i ++){
			String english = this.getCurWord(i).getEnglsh();
			if(english.startsWith(first))
				return english;
		}
		return null;
	}
	public String getListName(int n){
		return this.listName[n];
	}
}
