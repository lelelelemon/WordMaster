package Model;

import InterfaceOfModel.InterfaceOfWord;

public class Word implements InterfaceOfWord{
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
	
	public boolean isRight()
	{
		if(this.right > 0)
		{
			return true;
		}
		return false;
	}
	
	public Word(String english, String chinese, int wordList, int offset) {
		this.english = english;
		this.chinese = chinese;
		this.right = 0;
		this.total = 0;
		this.offset = offset;
		this.wordList = wordList;
	}

	public String getEnglsh() {
		return this.english;
	}

	public String getChinese() {
		return this.chinese;
	}

	public int getRight() {
		return this.right;
	}

	public int getTotal() {
		return this.total;
	}

	public int getOffset() {
		return this.offset;
	}

	public int getWordList() {
		return this.wordList;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setWordList(int wordList) {
		this.wordList = wordList;
	}
	
	// a/A 0
	public int charToInt(char a){
		String s =""+ a;
		s = s.toLowerCase();
		a = s.charAt(0);
		return a-'a';
	}
	
	public void addTotal()
	{
	     this.total++;
	}
	
	public void addRight()
	{
		this.right++;
	}
	
	// judge whether the word is right answered
	public boolean judge(String english){
		if(english.equals(this.english))
			return true;
		return false;
		
	}
	
	public boolean equals(Object b){
		Word word = (Word) b;
		if	(!word.getChinese().equals(this.chinese))
			return false;
		if (!word.getEnglsh().equals(this.english))
			return false;
		if (!(word.getWordList()==this.wordList))
			return false;
		return true;
		
	}
	
	
    
}
