package InterfaceOfModel;

import java.util.ArrayList;

public interface InterfaceOfIO {
	public ArrayList<InterfaceOfWord> readFirst(String filename);
	public InterfaceOfWordList read(String filename);
	public String writeWordList(InterfaceOfWordList wordList);

}
