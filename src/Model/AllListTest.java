package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class AllListTest {

	@Test
	public void testInitializeFirst() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		ArrayList<Word> allWords = new ArrayList();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		WordList wordListA = allList.getWordList(0);
		WordList wordListB = allList.getWordList(1);
		assertTrue("Test Failed",wordListA.getNextWord().equals(wordA));
		assertTrue("Test Failed",wordListB.getNextWord().equals(wordB));
		assertTrue("Test Failed",true);
	}

	@Test
	public void testInitialize() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		AllList allList = new AllList();
		allList.initialize(26);
		WordList wordListA = allList.getWordList(0);
		WordList wordListB = allList.getWordList(1);
		assertTrue("Test Failed",wordListA.getNextWord().equals(wordA));
		assertTrue("Test Failed",wordListB.getNextWord().equals(wordB));
	}

	@Test
	public void testWriteAllList() {
		assertTrue("Test Failed",true);

	}

	@Test
	public void testGetRight() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		wordA.setRight(1);
		wordB.setRight(0);
		wordA.setTotal(2);
		wordB.setTotal(2);
		ArrayList<Word> allWords = new ArrayList<Word>();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		assertTrue("Test Failed",allList.getRight()==1);

	}

	@Test
	public void testGetRecite() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		wordA.setRight(1);
		wordB.setRight(0);
		wordA.setTotal(2);
		wordB.setTotal(2);
		ArrayList<Word> allWords = new ArrayList<Word>();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		assertTrue("Test Failed",allList.getRecite()==2);
	}

	@Test
	public void testGetTotal() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		wordA.setRight(1);
		wordB.setRight(0);
		wordA.setTotal(2);
		wordB.setTotal(2);
		ArrayList<Word> allWords = new ArrayList<Word>();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		assertTrue("Test Failed",allList.getTotal()==2);
	}

	@Test
	public void testSetRecite() {
		assertTrue("Test Failed",true);

	}

	@Test
	public void testSetTotal() {
		assertTrue("Test Failed",true);
	}

	@Test
	public void testCalculateTotal() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		wordA.setRight(1);
		wordB.setRight(0);
		wordA.setTotal(2);
		wordB.setTotal(2);
		ArrayList<Word> allWords = new ArrayList<Word>();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		assertTrue("Test Failed",allList.getTotal()==2);
	}

	@Test
	public void testCalculateRecite() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		wordA.setRight(1);
		wordB.setRight(0);
		wordA.setTotal(2);
		wordB.setTotal(2);
		ArrayList<Word> allWords = new ArrayList<Word>();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		assertTrue("Test Failed",allList.getRecite()==2);
	}

	@Test
	public void testCalculateRight() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		wordA.setRight(1);
		wordB.setRight(0);
		wordA.setTotal(2);
		wordB.setTotal(2);
		ArrayList<Word> allWords = new ArrayList<Word>();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		assertTrue("Test Failed",allList.getRight()==1);
	}

	@Test
	public void testAddWordList() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		ArrayList<Word> allWords = new ArrayList();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		WordList wordListA = allList.getWordList(0);
		WordList wordListB = allList.getWordList(1);
		assertTrue("Test Failed",wordListA.getNextWord().equals(wordA));
		assertTrue("Test Failed",wordListB.getNextWord().equals(wordB));
		assertTrue("Test Failed",true);
	}

	@Test
	public void testAddWord() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		ArrayList<Word> allWords = new ArrayList();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		WordList wordListA = allList.getWordList(0);
		WordList wordListB = allList.getWordList(1);
		assertTrue("Test Failed",wordListA.getNextWord().equals(wordA));
		assertTrue("Test Failed",wordListB.getNextWord().equals(wordB));
		assertTrue("Test Failed",true);
	}

	@Test
	public void testGetWordList() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		ArrayList<Word> allWords = new ArrayList();
		allWords.add(wordA);
		allWords.add(wordB);
		AllList allList = new AllList();
		allList.initializeFirst(26, allWords);
		WordList wordListA = allList.getWordList(0);
		WordList wordListB = allList.getWordList(1);
		assertTrue("Test Failed",wordListA.getNextWord().equals(wordA));
		assertTrue("Test Failed",wordListB.getNextWord().equals(wordB));
		assertTrue("Test Failed",true);
	}

}
