package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class IOTest {

	@Test
	public void testReadFirst() {
		Word wordA = new Word("apple","Æ»¹û",0);
		Word wordB = new Word("banana","Ïã½¶",1);
		ArrayList<Word> expectedAllWords = new ArrayList();
		expectedAllWords.add(wordA);
		expectedAllWords.add(wordB);
		IO io = new IO();
		ArrayList<Word> allWords = io.readFirst("input.txt");
		assertTrue("Test Failed",allWords.get(0).equals(wordA));
		assertTrue("Test Failed",allWords.get(0).equals(wordA));
		assertTrue("Test Failed",allWords.size()==expectedAllWords.size());

		assertTrue("Test Failed",true);
	}

	@Test
	public void testRead() {
		Word wordA = new Word("apple","Æ»¹û",0);
		wordA.setTotal(1);
		wordA.setRight(1);
		WordList expectedWordList = new WordList(0);
		expectedWordList.addWord(wordA);
		expectedWordList.calculateRecite();
		expectedWordList.calculateRight();
		IO io = new IO();
		WordList wordList = io.read("0.txt");
		assertTrue("Test Failed",wordList.equals(expectedWordList));

	}

	@Test
	public void testWriteWordList() {
		assertTrue("Test Failed",true);
	}

}
