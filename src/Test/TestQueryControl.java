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
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		allList = context.mock(InterfaceOfAllList.class); 
		wordList = context.mock(InterfaceOfWordList.class);
		test = new QueryControl(allList); 
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
				allowing(allList).getWordList(10);
				will(returnValue(wordList));
				allowing(wordList).getSize();
				will(returnValue(50));
				allowing(wordList).getRecite();
				will(returnValue(40));
				allowing(wordList).getRight();
				will(returnValue(30));
			}
		});
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testLibraryAllTotal() {
		assertEquals(1000,test.getTotalWordNum("all"));
	}
	
	@Test
	public void testLibraryAllRecited() {
		assertEquals(300,test.getRecitedWordNum("all"));
	}
	
	@Test
	public void testLibraryAllRight() {
		assertEquals(200,test.getRightWordNum("all"));
	}
	
	@Test
	public void testLibraryAllWrong() {
		assertEquals(100,test.getWrongWordNum("all"));
	}
	
	@Test
	public void testLibraryAllRightRate() {
		assertEquals(0.6667,test.getRightRate("all"));
	}
	
	@Test
	public void testLibraryKTotal() {
		assertEquals(50,test.getTotalWordNum("k"));
	}
	
	@Test
	public void testLibraryKRicited() {
		assertEquals(40,test.getRecitedWordNum("k"));
	}
	@Test
	public void testLibraryKRight() {
		assertEquals(30,test.getRightWordNum("k"));
	}
	@Test
	public void testLibraryKWrong() {
		assertEquals(10,test.getWrongWordNum("k"));
	}
	@Test
	public void testLibraryKRightRate() {
		assertEquals(0.7500,test.getRightRate("k"));
	}
}
