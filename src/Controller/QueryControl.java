package Controller;

import java.math.BigDecimal;

import InterfaceOfModel.InterfaceOfAllList;

public class QueryControl implements QueryController {
	private InterfaceOfAllList allList;
	
	public QueryControl(InterfaceOfAllList allList){
		this.allList = allList;
	}
	
	@Override
	public int getTotalWordNum(String libname) {
		int total = 0;
		if(libname.equals("all")){
			total = allList.getTotal();
		}else{
			total = allList.getWordList((int)(libname.charAt(0)-'a')).getSize();
		}
		return total;
	}

	@Override
	public int getRecitedWordNum(String libname) {
		int recited = 0;
		if(libname.equals("all")){
			recited = allList.getRecite();
		}else{
			recited = allList.getWordList((int)(libname.charAt(0)-'a')).getRecite();
		}
		return recited;
	}

	@Override
	public int getRightWordNum(String libname) {
		int right = 0;
		if(libname.equals("all")){
			right = allList.getRight();
		}else{
			right = allList.getWordList((int)(libname.charAt(0)-'a')).getRight();
		}
		return right;
	}

	@Override
	public int getWrongWordNum(String libname) {
		int wrong = 0;
		if(libname.equals("all")){
			wrong = allList.getRecite() - allList.getRight();
		}else{
			wrong = allList.getWordList((int)(libname.charAt(0)-'a')).getRecite()-
					allList.getWordList((int)(libname.charAt(0)-'a')).getRight();
		}
		return wrong;
	}

	@Override
	public double getRightRate(String libname) {
		double rate = 0;
		if(libname.equals("all") && (double)allList.getRecite() != 0){
			rate = (double)allList.getRight()/(double)allList.getRecite();
		}else if(!libname.equals("all") && 
				allList.getWordList((int)(libname.charAt(0)-'a')).getRecite() != 0){
			rate = (double)allList.getWordList((int)(libname.charAt(0)-'a')).getRight()/
					(double)allList.getWordList((int)(libname.charAt(0)-'a')).getRecite();
		}
		
		//Àƒ…·ŒÂ»Î
		BigDecimal b = new BigDecimal(rate);
		rate = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		return rate;
	}

}
