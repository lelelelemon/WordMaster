package InterfaceOfModel;

import Model.Word;
import Model.WordList;

public interface InterfaceOfWordList {

	int getWordList();
	int getOffset();
	int getSize();
	int getRight();
	int getRecite();
	String getFileName();
	void setWordList(int wordList);
	void setOffset(int offset);
	void setSize(int size);
	void setRight(int right);
	void setRecite(int recite);
	void calculateRecite();
	void calculateRight();
	void addWord(Word word);
	WordList readWordList();
	void writeWordList();
	Word getNextWord();
	Word getCurWord(int i);
	boolean equals(Object b);
}
