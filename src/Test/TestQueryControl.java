package Test;

import junit.framework.TestCase;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controller.QueryControl;
import InterfaceOfModel.InterfaceOfAllList;
import InterfaceOfModel.InterfaceOfWordList;

public class TestQueryControl extends TestCase{

	private Mockery context = new JUnit4Mockery(); 
	private InterfaceOfAllList allList = null; 
	private InterfaceOfWordList wordList = null;
	private QueryControl test = null;
	private InterfaceOfAllList specialAllList;
	private InterfaceOfWordList specialWordList = null;
	private QueryControl test2 = null;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		allList = context.mock(InterfaceOfAllList.class); 
		specialAllList = context.mock(InterfaceOfAllList.class,"specialAllList"); 
		wordList = context.mock(InterfaceOfWordList.class);
		specialWordList  = context.mock(InterfaceOfWordList.class,"specialWordList");
		test = new QueryControl(allList); 
		test2 = new QueryControl(specialAllList);
		context.checking(new Expectations() {
			{
				allowing(allList).getTotal();
				will(returnValue(1000));
				allowing(allList).getRecite();
				will(returnValue(300));
				allowing(allList).getRight();
				will(returnValue(200));
			} 
		}); 
		
		context.checking(new Expectations() {
			{
				allowing(allList).getWordList(1);
				will(returnValue(wordList));
				allowing(wordList).getSize();
				will(returnValue(50));
				allowing(wordList).getRecite();
				will(returnValue(40));
				allowing(wordList).getRight();
				will(returnValue(30));
			}
		});
		
		context.checking(new Expectations() {
			{
				allowing(specialAllList).getTotal();
				will(returnValue(0));
				allowing(specialAllList).getRecite();
				will(returnValue(0));
				allowing(specialAllList).getRight();
				will(returnValue(0));
			} 
		}); 
		
		context.checking(new Expectations() {
			{
				allowing(specialAllList).getWordList(0);
				will(returnValue(specialWordList));
				allowing(specialWordList).getSize();
				will(returnValue(0));
				allowing(specialWordList).getRecite();
				will(returnValue(0));
				allowing(specialWordList).getRight();
				will(returnValue(0));
			}
		});
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testLibraryAll() {
		assertEquals(1000,test.getTotalWordNum(10));
		assertEquals(300,test.getRecitedWordNum(10));
		assertEquals(200,test.getRightWordNum(10));
		assertEquals(100,test.getWrongWordNum(10));
		assertEquals(0.6667,test.getRightRate(10));
	}
	
	@Test
	public void testLibrary2() {
		assertEquals(50,test.getTotalWordNum(1));
		assertEquals(40,test.getRecitedWordNum(1));
		assertEquals(30,test.getRightWordNum(1));
		assertEquals(10,test.getWrongWordNum(1));
		assertEquals(0.7500,test.getRightRate(1));
	}
	
	@Test
	public void testEmptyAll() {
		assertEquals(0,test2.getTotalWordNum(10));
		assertEquals(0,test2.getRecitedWordNum(10));
		assertEquals(0,test2.getRightWordNum(10));
		assertEquals(0,test2.getWrongWordNum(10));
		assertEquals(0.0000,test2.getRightRate(10));
	}
	
	@Test
	public void testEmptyLibrary() {
		assertEquals(0,test2.getTotalWordNum(0));
		assertEquals(0,test2.getRecitedWordNum(0));
		assertEquals(0,test2.getRightWordNum(0));
		assertEquals(0,test2.getWrongWordNum(0));
		assertEquals(0.0000,test2.getRightRate(0));
	}
}
