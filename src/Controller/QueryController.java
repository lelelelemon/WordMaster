package Controller;

//为查询页面服务的控制器接口
public interface QueryController {
	public int getTotalWordNum(String libname);//根据词库名获取词库单词总数
	public int getRecitedWordNum(String libname);//根据词库名获取词库中已背单词数
	public int getRightWordNum(String libname);//根据词库名获取词库中背诵的正确单词数
	public int getWrongWordNum(String libname);//根据词库名获取词库背诵的错误单词数
	public double getRightRate(String libname);//根据词库名获取词库背诵正确率
}
