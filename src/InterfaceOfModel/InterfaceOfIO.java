package InterfaceOfModel;

import java.util.ArrayList;

import Model.Word;
import Model.WordList;

public interface InterfaceOfIO {
	ArrayList<Word> readFirst(String filename);
	WordList read(String filename);
	String writeWordList(WordList wordList);

}
