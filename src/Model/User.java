package Model;

import java.util.ArrayList;

import InterfaceOfModel.InterfaceOfUser;

public class User implements InterfaceOfUser{
	private AllList alllist;
	private int curList;// denote the list user choose
	private int offset;// denote the offset of the recite 
	private int start; // denote the word user choose to start
	private int number; // denote the number of words user choose to recite
	private String username;
	private String password;
	private static boolean first = true;// remeber whether the first to

	public User() {

	}

	// initiate the alllist
	public User(int number, String filename) {
		User user = new User();
		if(first)
			initializeFirst(number, filename);
		else
			initialize(number);

	}

	// finish the initialize work including read the inputfile initiate alllist
	//fisrt use
	public void initializeFirst(int number, String filename) {
		
		/*
		 * 1. if firstTime, read the specific TXT,
		 * return an arraylist of words 
		 * ArrayList<Word> allWords = read(filename); 
		 * 2.initialize the alllist
		 */
		IO io = new IO();
		ArrayList<Word> allWords = io.readFirst(filename); 
		this.alllist = new AllList();
		alllist.initializeFirst(number, allWords);
		this.first = false;

	}
	// not first use
	public void initialize(int number) {
		/*
		read from each corresponding file to construct the alllist
		 */
		this.alllist = new AllList();
		alllist.initialize(number);

	}


	public int getCurList() {
		return curList;
	}

	public boolean getFirst() {
		return first;
	}

	public int getStart() {
		return start;
	}

	public int getNumber() {
		return number;
	}

	public void setCurList(int curList) {
		this.curList = curList;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	// judge the number user chooser to recite is legal or not
	public boolean judgeNumber(int number) {
		int total = this.alllist.getWordList(curList).getSize();
		if((total - start + 1) > number)
		{
			return true;
		}

		return false;
	}

	// find the word with the specific english within the alllist
	public Word search(String english) {
		char firstChar = english.toLowerCase().charAt(0);
		int seq = firstChar -'a';
		WordList wordlist = (WordList) alllist.getWordList(seq);
		for(int i = 0; i < wordlist.getSize();i++)
		{
			if(english.equals(wordlist.getCurWord(i).getEnglsh()))
			{
				return wordlist.getCurWord(i);
			}
		}
		// no word match the input, set the start from the beginning of curlist
		return wordlist.getCurWord(0);
	}
	
	// get the current recite word
	public Word getCurWord(){
		Word word = new Word();
		word = this.alllist.getWordList(curList).getCurWord(offset);
		return word;
	}
	
	// return alllist
	public AllList getAllList(){
		return this.alllist;
	}
	
	
}
