package InterfaceOfModel;

public interface InterfaceOfWord {

	boolean isRight();
	String getEnglsh();
	String getChinese();
	int getRight();
	int getTotal();
	int getOffset();
	int getWordList();
	void setEnglish(String english);
	void setChinese(String chinese);
	void setRight(int right);
	void setTotal(int total);
	void setOffset(int offset);
	void setWordList(int wordList);
	int charToInt(char a);
	void addTotal();
	void addRight();
	boolean judge(String english);
	boolean equals(Object b);
	
}
