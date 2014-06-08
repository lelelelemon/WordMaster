package Model;

import InterfaceOfModel.*;

public class Task implements InterfaceOfTask{
	private InterfaceOfWordList wordList;
	private int total;
	private int right;
	private int recite;
	private int start;
	private Word curWord;
	
	public Task()
	{
		
	}
	
	public Task(InterfaceOfWordList wordList, int start, int length)
	{
		this.wordList = wordList;
		this.start = start;
		this.total = length;
		if (start+this.total>wordList.getSize())
			this.total = wordList.getSize()-start;
		this.recite=0;
		next();
		
	}
	
	public InterfaceOfWordList getWordList()
	{
		return wordList;
	}
	
	
	public int getRight()
	{
		return this.right;
	}
	
	public int getRecite()
	{
		return this.recite;
	}
	
	public int getStart()
	{
		return this.start;
	}
	
	public int getTotal(){
		
		return this.total;
		
	}
	 // get the current word
	public InterfaceOfWord getWord(){
		InterfaceOfWord w = (InterfaceOfWord) wordList.getCurWord(start + recite);
		return w;
	}
	// get the current word's chinese 
	public String getChinese(){
		Word w = (Word) this.getWord();
		String ch = w.getChinese();
		return ch;
	}
	
	// get the current word's english
	public String getEnglish(){
		Word w = (Word) this.getWord();
		String en =w.getEnglsh();
		return en;
	}
	
	
    // update the information
	public void update(boolean result){
		//update task's attribute
		recite++;
		curWord.addTotal();
		
		
		if(result)
		{
			right++;
			curWord.addRight();	
		}
		wordList.setOffset(start + recite);
		wordList.writeWordList();
		next();
		
	}
	
	// point to next word
	public void next(){
		if (start+recite<wordList.getSize()){
			curWord = (Word) wordList.getCurWord(start+recite);
		}
	}
	
	public boolean checkFinish(){
		if	(wordList.getRecite()==wordList.getSize())
			return true;
		return false;
	}
}
