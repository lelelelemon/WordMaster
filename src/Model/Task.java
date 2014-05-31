package Model;

public class Task {
	private WordList wordList;
	private int total;
	private int right;
	private int recite;
	private int start;
	int getTotal(){
		return this.total;
	}
	// get the current word
	Word getWord(){
		return null;
	}
	// get the current word's chinese 
	String getChinese(){
		return null;
	}
	// get the current word's english
	String getEnglish(){
		return null;
	}
	// check whether the task is over  and also do update job here
	boolean checkOver(){
		return true;
	}
	// check whether the meaning is right
	boolean checkRight(){
		return true;
	}
    // update the information
	boolean update(){
		return true;
	}
	// point to next word
	void next(){
		
	}
	
}
