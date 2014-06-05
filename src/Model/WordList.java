package Model;

import java.util.ArrayList;

public class WordList {
	private ArrayList<Word> words;
	private int wordList;
	private int offset = 0; // the offset of the word recited to
	private int size = 0;// the size of the wordList
	private int right = 0;// the right number of recited words
	private int recite = 0;// the number of recited words
	private String fileName;// each WordList correspond to a file

	public WordList() {
		words = new ArrayList<Word>();
	}

	public WordList(int i) {
		words = new ArrayList<Word>();
		this.wordList = i;
		this.fileName = i + ".txt";

	}

	int getWordList() {
		return this.wordList;
	}

	int getOffset() {
		return this.offset;
	}

	int getSize() {
		return this.size;
	}

	int getRight() {
		return this.right;
	}

	int getRecite() {
		return this.recite;
	}

	String getFileName() {
		return this.fileName;
	}

	void setWordList(int wordList) {
		this.wordList = wordList;
	}

	void setOffset(int offset) {
		this.offset = offset;
	}

	void setSize(int size) {
		this.size = size;
	}

	void setRight(int right) {
		this.right = right;
	}

	void setrecite(int recite) {
		this.recite = recite;
	}

	// get through the arraylist and choose the word recited and return the
	// arraylist of all the recited words;
   void calculateRecite() {
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
	void calculateRight() {
		for (int i = 0; i < words.size(); i++) {
			Word word = words.get(i);
			if (word.getRight() > 0) {
				right++;
			}
		}

	}

	// add a new word to the arraylist
	void addWord(Word word) {
		words.add(word);
		word.setOffset(size);
		this.size++;
	}

	WordList readWordList() {
		IO io = new IO();
		return io.read(fileName);
	}

	void writeWordList() {
		IO io = new IO();
		io.writeWordList(this);
	}
	// get next word
	Word getNextWord(){
		this.offset++;
		return this.words.get(this.offset - 1);
	}
	// get current word
	Word getCurWord(int i){
		return this.words.get(i);
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
}
