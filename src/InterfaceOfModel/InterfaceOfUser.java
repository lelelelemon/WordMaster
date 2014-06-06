package InterfaceOfModel;

import Model.AllList;
import Model.Word;

public interface InterfaceOfUser {

	void initializeFirst(int number, String filename);
	void initialize(int number);
	int getCurList();
	boolean getFirst();
	int getStart();
	int getNumber();
	void setCurList(int curList);
	void setStart(int start);
	void setNumber(int number);
	boolean judgeNumber(int number);
	Word search(String english);
	Word getCurWord();
	AllList getAllList();
}
