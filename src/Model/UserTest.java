package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UserTest {

	@Test
	public void testGetCurList() {
		User user = new User(26,"input.txt");
		user.setCurList(1);
		assertTrue("Test Failed",user.getCurList()==1);		
		assertTrue("Test Failed",true);

	}

	@Test
	public void testGetFirst() {
		User user = new User(26,"input.txt");
		assertTrue("Test Failed",user.getFirst()==false);

	}

	@Test
	public void testGetStart() {
		User user = new User(26,"input.txt");
		user.setStart(2);
		assertTrue("Test Failed",user.getStart()==2);	
	}

	@Test
	public void testGetNumber() {
		User user = new User(26,"input.txt");
		user.setNumber(3);;
		assertTrue("Test Failed",user.getNumber()==3);	
	}

	@Test
	public void testSetCurList() {
		User user = new User(26,"input.txt");
		user.setCurList(1);
		assertTrue("Test Failed",user.getCurList()==1);	
	}

	@Test
	public void testSetStart() {
		User user = new User(26,"input.txt");
		user.setStart(2);
		assertTrue("Test Failed",user.getStart()==2);	
	}

	@Test
	public void testSetNumber() {
		User user = new User(26,"input.txt");
		user.setNumber(3);;
		assertTrue("Test Failed",user.getNumber()==3);
	}

	@Test
	public void testJudgeNumber() {
		User user = new User(26,"input.txt");
		user.setCurList(0);
		user.setStart(0);
		assertTrue("Test Failed",user.judgeNumber(1)==true);
		user.setStart(1);
		assertTrue("Test Failed",user.judgeNumber(1)==false);
		user.setCurList(1);
		user.setStart(0);
		assertTrue("Test Failed",user.judgeNumber(1)==true);
		user.setCurList(2);
		user.setStart(0);
		assertTrue("Test Failed",user.judgeNumber(1)==false);

	}

	@Test
	public void testSearch() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		User user = new User(26,"input.txt");
		user.setCurList(0);
		user.setStart(0);
		Word result;
		result = user.search("apple");
		assertTrue("Test Failed",result.equals(wordA));
		result = user.search("after");
		assertTrue("Test Failed",result==null);
		user.setStart(0);
		user.setCurList(1);
		result = user.search("banana");
		assertTrue("Test Failed",result.equals(wordB));


	}


}
