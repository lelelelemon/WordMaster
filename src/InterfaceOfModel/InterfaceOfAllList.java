package InterfaceOfModel;

import java.util.ArrayList;

import Model.AllList;
import Model.Word;
import Model.WordList;

public interface InterfaceOfAllList {
	void initializeFirst(int number, ArrayList<Word> allWords);
	void initialize(int number);
	void writeAllList(int number, AllList alllist);
	int getRight();
	int getRecite();
	int getTotal();
	void setRecite(int recite);
	void setTotal(int total);
	void calculateTotal();
	void calculateRecite();
	void calculateRight();
	void addWordList(WordList wordList);
	void addWord(Word word);
	WordList getWordList(int i);
	int [] getRecord(int wordlist);
}
