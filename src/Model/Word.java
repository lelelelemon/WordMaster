package Model;

public class Word {
	private String english;
	private String chinese;
	private int right; // the number of right times
	private int total; // the number of total recite times
	private int offset;// the offset in the wordlist
	private int wordList;// in which wordList

	public Word() {

	}

	public Word(String english, String chinese, int wordList) {
		this.english = english;
		this.chinese = chinese;
		this.right = 0;
		this.total = 0;
		this.wordList = wordList;
	}
	public Word(String english, String chinese, int wordList, int offset) {
		this.english = english;
		this.chinese = chinese;
		this.right = 0;
		this.total = 0;
		this.offset = offset;
		this.wordList = wordList;
	}

	String getEnglsh() {
		return this.english;
	}

	String getChinese() {
		return this.chinese;
	}

	int getRight() {
		return this.right;
	}

	int getTotal() {
		return this.total;
	}

	int getOffset() {
		return this.offset;
	}

	int getWordList() {
		return this.wordList;
	}

	void setEnglish(String englsih) {
		this.english = english;
	}

	void setChinese(String chinese) {
		this.chinese = chinese;
	}

	void setRight(int right) {
		this.right = right;
	}

	void setTotal(int total) {
		this.total = total;
	}

	void setOffset(int offset) {
		this.offset = offset;
	}

	void setWordList(int wordList) {
		this.wordList = wordList;
	}
	// a/A 0
	int charToInt(char a){
		return 0;
	}
	// judge whether the word is right answered
	boolean judge(String english){
		if(english.equals(this.english))
			return true;
		return false;
	}
    
}
