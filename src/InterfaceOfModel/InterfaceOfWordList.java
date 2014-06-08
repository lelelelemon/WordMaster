package InterfaceOfModel;

public interface InterfaceOfWordList {

	public int getWordList();
	public int getOffset();
	public int getSize();
	public int getRight();
	public int getRecite();
	public String getFileName();
	public void setWordList(int wordList);
	public void setOffset(int offset);
	public void setSize(int size);
	public void setRight(int right);
	public void setRecite(int recite);
	public void calculateRecite();
	public void calculateRight();
	public void addWord(InterfaceOfWord word);
	public InterfaceOfWordList readWordList();
	public void writeWordList();
	public InterfaceOfWord getNextWord();
	public InterfaceOfWord getCurWord(int i);
	public boolean equals(Object b);
}
