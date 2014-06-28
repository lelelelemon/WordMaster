package Model;

import java.io.*;

import InterfaceOfModel.*;
public class User implements InterfaceOfUser{
	private AllList allList;
	private int curList;// denote the list user choose
	private int start; // denote the word user choose to start
	private int number; // denote the number of words user choose to recite
	private String username;
	private String password;
	private static boolean first = true;// remeber whether the first to

	public User() {

	}

	// initiate the alllist
	public User(int number, String filename) {
		File file = new File("0.txt");
		if	(file.exists())
			first = true;		
		if(first)
			initializeFirst(number, filename);
		else
			initialize(number);

	}

	// finish the initialize work including read the inputfile initiate alllist
	//fisrt use
	public void initializeFirst(int number, String filename) {
		IO io = new IO();
		this.allList = new AllList();
		allList.initializeFirst(number, io.readFirst(filename));
		return;
	}
	// not first use
	public void initialize(int number) {
		/*
		read from each corresponding file to construct the alllist
		 */
		this.allList = new AllList(number);
		for (int i=0; i<number; i++)
			this.allList.getWordList(i).readWordList();
		return;

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
		int total = this.allList.getWordList(curList).getSize();
		if((total - start + 1) > number)
		{
			return true;
		}

		return false;
	}

	// find the word with the specific english within the alllist
	public InterfaceOfWord search(String english) {
		char firstChar = english.toLowerCase().charAt(0);
		int seq = firstChar -'a';
		WordList wordlist = (WordList) allList.getWordList(seq);
		if (wordlist.getSize()==0)
			return null;
		for(int i = 0; i < wordlist.getSize();i++)
		{
			if(english.equals(wordlist.getCurWord(i).getEnglsh()))
			{
				return (InterfaceOfWord) wordlist.getCurWord(i);
			}
		}
		return null;
	}
	
	public InterfaceOfAllList getAllList(){
		return this.allList;
	}
	
	
}
