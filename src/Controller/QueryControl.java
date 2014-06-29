package Controller;

import java.math.BigDecimal;

import InterfaceOfModel.InterfaceOfAllList;

public class QueryControl implements QueryController {
	private InterfaceOfAllList allList;
	
	public QueryControl(InterfaceOfAllList allList){
		this.allList = allList;
	}
	
	@Override
	public int getTotalWordNum(int libname) {
		int total = 0;
		if(libname == 10){
			total = allList.getTotal();
		}else{
			total = allList.getWordList(libname).getSize();
			//total = allList.getWordList((int)(libname.charAt(0)-'a')).getSize();
		}
		return total;
	}

	public int getRecitedWordNum(int libname) {
		int recited = 0;
		if(libname == 10){
			recited = allList.getRecite();
		}else{
			recited = allList.getWordList(libname).getRecite();
		}
		return recited;
	}

	@Override
	public int getRightWordNum(int libname) {
		int right = 0;
		if(libname == 10){
			right = allList.getRight();
		}else{
			right = allList.getWordList(libname).getRight();
		}
		return right;
	}

	@Override
	public int getWrongWordNum(int libname) {
		int wrong = 0;
		if(libname == 10){
			wrong = allList.getRecite() - allList.getRight();
		}else{
			wrong = allList.getWordList(libname).getRecite()-
					allList.getWordList(libname).getRight();
		}
		return wrong;
	}

	@Override
	public double getRightRate(int libname) {
		double rate = 0;
		if(libname == 10 && (double)allList.getRecite() != 0){
			rate = (double)allList.getRight()/(double)allList.getRecite();
		}else if(! (libname == 10)&& 
				allList.getWordList(libname).getRecite() != 0){
			rate = (double)allList.getWordList(libname).getRight()/
					(double)allList.getWordList(libname).getRecite();
		}
		
		//Àƒ…·ŒÂ»Î
		BigDecimal b = new BigDecimal(rate);
		rate = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		return rate;
	}

}
