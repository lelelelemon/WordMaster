package Model;

public class Task {
	private WordList wordList;
	private int total;
	private int right;
	private int recite;
	private int start;
	private Word curWord;
	private String text; //user input
	public Task(){
		
	}
	// Initialize the task use give wordlis, start and number;
	public Task(WordList wordlist, int start, int number){
		this.wordList = wordList;
		this.start = start;
		this.total = number;
		if(checkNumber() != 0)
			this.total = checkNumber();
	}
	
	int getRight()
	{
		return this.right;
	}
	
	int getRecite()
	{
		return this.recite;
	}
	
	int getStart()
	{
		return this.start;
	}
	
	int getTotal(){
		
		return this.total;
		
	}
	// get the current word
	Word getWord(){
		Word w = wordList.getCurWord(start + recite);
		return w;
	}
	// get the current word's chinese 
	String getChinese(){
		Word w = this.getWord();
		String ch = w.getChinese();
		return ch;
	}
	
	// get the current word's english
	String getEnglish(){
		Word w = this.getWord();
		String en =w.getEnglsh();
		return en;
	}
	
	// check whether the task is over  and also do update job here
	boolean checkOver(){
		update();
		if(recite == total)
		{
		   return true;
		}
		else
		{
			return false;
		}
	}
	
	// check whether the meaning is right
	boolean checkRight(){
		if(text.equals(curWord.getEnglsh()))
		{
		   return true;
		}
		else
		{
			return false;
		}
	}
	
    // update the information
	boolean update(){
		//update task's attribute
		recite++;
		curWord.addTotal();
		
		if(curWord.getTotal()<1)
		{
			wordList.setrecite(wordList.getRecite()+1);
		}
		if(checkRight())
		{
			right++;
			if(curWord.getRight()<1)
			{
			   wordList.setRight(wordList.getRight() + 1);
			}
			curWord.addRight();
			
		}
		wordList.setOffset(start + recite);
		//point to next one;
		next();
		
		return true;
	}
	// check the number is legal or not, if legal return 0, else return the max number you can recite
	int checkNumber(){
		int size = wordList.getSize();
		if(start + total >= size)
			return 0;
		return total - start;
		
	}
	// point to next word
	void next(){
		curWord = wordList.getCurWord(curWord.getOffset() + 1);
	}
	// get the remaining word
	int getRemain(){
		return total - recite;
	}
}
