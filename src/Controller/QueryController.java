package Controller;

//Ϊ��ѯҳ�����Ŀ������ӿ�
public interface QueryController {
	public int getTotalWordNum(String libname);//���ݴʿ�����ȡ�ʿⵥ������
	public int getRecitedWordNum(String libname);//���ݴʿ�����ȡ�ʿ����ѱ�������
	public int getRightWordNum(String libname);//���ݴʿ�����ȡ�ʿ��б��е���ȷ������
	public int getWrongWordNum(String libname);//���ݴʿ�����ȡ�ʿⱳ�еĴ��󵥴���
	public double getRightRate(String libname);//���ݴʿ�����ȡ�ʿⱳ����ȷ��
}
