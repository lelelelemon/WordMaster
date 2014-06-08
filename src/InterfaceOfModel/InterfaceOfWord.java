package InterfaceOfModel;

public interface InterfaceOfWord {

	public boolean isRight();
	public String getEnglsh();
	public String getChinese();
	public int getRight();
	public int getTotal();
	public int getOffset();
	public int getWordList();
	public void setEnglish(String english);
	public void setChinese(String chinese);
	public void setRight(int right);
	public void setTotal(int total);
	public void setOffset(int offset);
	public void setWordList(int wordList);
	public int charToInt(char a);
	public void addTotal();
	public void addRight();
	public boolean judge(String english);
	public boolean equals(Object b);	
}
