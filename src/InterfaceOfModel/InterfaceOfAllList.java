package InterfaceOfModel;

import java.util.ArrayList;

public interface InterfaceOfAllList {
	public void initializeFirst(int number, ArrayList<InterfaceOfWord> allWords);
	public void initialize(int number);
	public void writeAllList(int number, InterfaceOfAllList alllist);
	public int getRight();
	public int getRecite();
	public int getTotal();
	public void setRecite(int recite);
	public void setTotal(int total);
	public void calculateTotal();
	public void calculateRecite();
	public void calculateRight();
	public void addWordList(InterfaceOfWordList wordList);
	public void addWord(InterfaceOfWord word);
	public InterfaceOfWordList getWordList(int i);
	public String getListName(int n);
}
