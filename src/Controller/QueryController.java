package Controller;

//为查询页面服务的控制器接口
public interface QueryController {
	public int getTotalWordNum(int libname);//根据词库名获取词库单词总数
	public int getRecitedWordNum(int libname);//根据词库名获取词库中已背单词数
	public int getRightWordNum(int libname);//根据词库名获取词库中背诵的正确单词数
	public int getWrongWordNum(int libname);//根据词库名获取词库背诵的错误单词数
	public double getRightRate(int libname);//根据词库名获取词库背诵正确率
}
