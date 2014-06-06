package InterfaceOfModel;

import Model.Word;
import Model.WordList;

public interface InterfaceOfTask {
	int getRight();
	int getRecite();
	int getStart();
	int getTotal();
	Word getWord();
	String getChinese();
	String getEnglish();
	boolean checkOver();
	boolean checkRight();
	boolean update();
	boolean checkNumber();
	void next();
}
