package Controller;

//Ϊ��ѯҳ�����Ŀ������ӿ�
public interface QueryController {
	public int getTotalWordNum(int libname);//���ݴʿ�����ȡ�ʿⵥ������
	public int getRecitedWordNum(int libname);//���ݴʿ�����ȡ�ʿ����ѱ�������
	public int getRightWordNum(int libname);//���ݴʿ�����ȡ�ʿ��б��е���ȷ������
	public int getWrongWordNum(int libname);//���ݴʿ�����ȡ�ʿⱳ�еĴ��󵥴���
	public double getRightRate(int libname);//���ݴʿ�����ȡ�ʿⱳ����ȷ��
}
