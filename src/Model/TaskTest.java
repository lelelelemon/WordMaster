package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {

	@Test
	public void testGetWordList() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		assertTrue("Test Failed",task.getWordList()==wl);

		assertTrue("Test Failed",true);

	}

	@Test
	public void testGetRight() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		task.update(false);
		assertTrue("Test Failed",task.getRight()==0);
		task.update(true);
		assertTrue("Test Failed",task.getRight()==1);

		
	}

	@Test
	public void testGetRecite() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		task.update(false);
		assertTrue("Test Failed",task.getRecite()==1);
		task.update(true);
		assertTrue("Test Failed",task.getRecite()==2);
	}

	@Test
	public void testGetStart() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 1, 2);
		assertTrue("Test Failed",task.getStart()==1);

	}

	@Test
	public void testGetTotal() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		assertTrue("Test Failed",task.getTotal()==2);
		task = new Task(wl, 0, 100);
		assertTrue("Test Failed",task.getTotal()==2);

	}

	@Test
	public void testGetWord() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		assertTrue("Test Failed",task.getWord().equals(wordA));
		task.update(true);
		assertTrue("Test Failed",task.getWord().equals(wordB));


	}

	@Test
	public void testGetChinese() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		assertTrue("Test Failed",task.getChinese().equals("Æ»¹û"));
		task.update(true);
		assertTrue("Test Failed",task.getChinese().equals("Ïã½¶"));
	}

	@Test
	public void testGetEnglish() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		assertTrue("Test Failed",task.getEnglish().equals("apple"));
		task.update(true);
		assertTrue("Test Failed",task.getEnglish().equals("apple2"));
	}

	@Test
	public void testUpdate() {
		assertTrue("Test Failed",true);
	}

	@Test
	public void testNext() {
		assertTrue("Test Failed",true);

	}

	@Test
	public void testCheckFinish() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wl.addWord(wordA);
		wl.addWord(wordB); 
		Task task = new Task(wl, 0, 2);
		task.update(true);
		assertTrue("Test Failed",task.checkFinish()==false);
		task.update(false);
		assertTrue("Test Failed",task.checkFinish()==true);

	}

}
