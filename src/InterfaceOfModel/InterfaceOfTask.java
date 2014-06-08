package InterfaceOfModel;

public interface InterfaceOfTask {
	public int getRight();
	public int getRecite();
	public int getStart();
	public int getTotal();
	public InterfaceOfWord getWord();
	public String getChinese();
	public String getEnglish();
	public void update(boolean result);
	public void next();
	public boolean checkFinish();
}
