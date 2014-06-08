package InterfaceOfModel;

public interface InterfaceOfUser {

	public void initializeFirst(int number, String filename);
	public void initialize(int number);
	public int getCurList();
	public boolean getFirst();
	public int getStart();
	public int getNumber();
	public void setCurList(int curList);
	public void setStart(int start);
	public void setNumber(int number);
	public boolean judgeNumber(int number);
	public InterfaceOfWord search(String english);
	public InterfaceOfAllList getAllList();
}
