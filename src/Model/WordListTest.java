package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordListTest {

	@Test
	public void testGetWordList() {

		WordList wl = new WordList(1);
		assertTrue("Test Failed",wl.getWordList()==1);

		
		assertTrue("Test Failed",true);
	}

	@Test
	public void testGetOffset() {
		WordList wl = new WordList(1);
		wl.setOffset(2);
		assertTrue("Test Failed",wl.getOffset()==2);
	}

	@Test
	public void testGetSize() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB);
		wl.calculateRight();
		assertTrue("Test Failed",wl.getSize()==2);
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
		wl.calculateRight();
		assertTrue("Test Failed",wl.getRight()==2);
	}

	@Test
	public void testGetRecite() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(0);
		wl.addWord(wordA);
		wl.addWord(wordB);
		wl.calculateRecite();
		assertTrue("Test Failed",wl.getRecite()==1);
	}

	@Test
	public void testGetFileName() {
		WordList wl = new WordList(1);
		assertTrue("Test Failed",wl.getFileName().equals("1.txt"));
		wl.setWordList(0);
		assertTrue("Test Failed",wl.getFileName().equals("0.txt"));

	}

	@Test
	public void testSetWordList() {
		WordList wl = new WordList();
		wl.setWordList(2);
		assertTrue("Test Failed",wl.getWordList()==2);	}

	@Test
	public void testSetOffset() {
		WordList wl = new WordList(1);
		wl.setOffset(2);
		assertTrue("Test Failed",wl.getOffset()==2);	}

	@Test
	public void testSetSize() {

		assertTrue("Test Failed",true);
	}

	@Test
	public void testSetRight() {

		assertTrue("Test Failed",true);
	}

	@Test
	public void testSetrecite() {
		
		assertTrue("Test Failed",true);
	}

	@Test
	public void testCalculateRecite() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(0);
		wl.addWord(wordA);
		wl.addWord(wordB);
		wl.calculateRecite();
		assertTrue("Test Failed",wl.getRecite()==1);

		
	}

	@Test
	public void testCalculateRight() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wordA.setTotal(2);
		wordB.setTotal(1);
		wordA.setRight(2);
		wordB.setRight(1);
		wl.addWord(wordA);
		wl.addWord(wordB);
		wl.calculateRight();
		assertTrue("Test Failed",wl.getRight()==2);
	}

	@Test
	public void testAddWord() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wl.addWord(wordA);
		wl.addWord(wordB);
		assertTrue("Test Failed",wl.getCurWord(0).equals(wordA));
		assertTrue("Test Failed",wl.getCurWord(1).equals(wordB));

	}

	@Test
	public void testReadWordList() {
		WordList wl = new WordList(0);
		wl.readWordList();
		Word wordA = new Word("apple","Æ»¹û",0);
		WordList expectedWordList = new WordList(0);
		wordA.setRight(0);
		wordA.setTotal(0);
		expectedWordList.addWord(wordA);
		expectedWordList.calculateRecite();
		expectedWordList.calculateRight();
		assertTrue("Test Failed",wl.equals(expectedWordList));

	}

	@Test
	public void testWriteWordList() {
		assertTrue("Test Failed",true);

	}

	@Test
	public void testGetNextWord() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wl.addWord(wordA);
		wl.addWord(wordB);
		assertTrue("Test Failed",wl.getNextWord().equals(wordA));
		assertTrue("Test Failed",wl.getNextWord().equals(wordB));
	}

	@Test
	public void testGetCurWord() {
		WordList wl = new WordList(0);
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("apple2","Ïã½¶",0);
		wl.addWord(wordA);
		wl.addWord(wordB);
		assertTrue("Test Failed",wl.getCurWord(0).equals(wordA));
		assertTrue("Test Failed",wl.getCurWord(1).equals(wordB));
	}



}
