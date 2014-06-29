package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

import InterfaceOfModel.*;



public class IO implements InterfaceOfIO{
	// read all the word in to an arraylist of Word
	/*
	public ArrayList<InterfaceOfWord> readFirst(String filename){
		
		ArrayList<InterfaceOfWord> arrayList = new ArrayList<InterfaceOfWord>();
		try{
			FileInputStream fis = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			
			
			String line="";
			while ((line=br.readLine())!=null){
				String[] buf = line.split(" ");
				char startChar =  buf[0].toLowerCase().charAt(0);			
				int wordlist =startChar-'a';
				String sub = line.substring(buf[0].length());
				sub = sub.replaceAll(" ", "");
				Word word = new Word(buf[0],sub,wordlist);
				arrayList.add((InterfaceOfWord) word);
			}
			
			br.close();
			
		}catch(IOException exception){
			
		}
		return arrayList;
	
	}
	*/
	public ArrayList<InterfaceOfWord> readFirst(String filename){
		return new DomParse().DomParse(filename);
	}
	//  we can read from each correspoding file  such as 1.txt => wordlist A
	public InterfaceOfWordList read(String filename) {
		/* offset size right recite
		 * english chinese right total
		 * english chinese right total		
		 */
		
		WordList wordList = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String[] fs = filename.split("\\/");
			String fn = fs[fs.length-1];
			int wordListNumber = Integer.parseInt(fn.split("\\.")[0]);
			wordList = new WordList(wordListNumber);
			String line;
			int count=0;
			if ((line = br.readLine())!=null){
				String[] buf = line.split(" ");
				int offset = Integer.parseInt(buf[0]);
				int size = Integer.parseInt(buf[1]);
				int right = Integer.parseInt(buf[2]);
				int recite = Integer.parseInt(buf[3]);
				wordList.setOffset(offset);
				//wordList.setSize(size);
				wordList.setRight(right);
				wordList.setRecite(recite);
			}
			while ((line=br.readLine())!=null){
				String[] buf = line.split(" ");
				int wordlist = wordListNumber;
				int right = Integer.parseInt(buf[2]);
				int total = Integer.parseInt(buf[3]);
				Word word = new Word(buf[0],buf[1],wordlist,count);
				word.setRight(right);
				word.setTotal(total);
				wordList.addWord(word);
				count++;
			}
			
			
			br.close();
			
		}catch(IOException exception){
			
		}
		return wordList;
	}

	// write correesponding record to files such as wordlist A => 1.txt( 1.txt is the name we specific for each Word)
	public String writeWordList(InterfaceOfWordList wordList){
		/* offset size right recite
		 * english chinese right total
		 * english chinese right total		
		 */
		String fileName = wordList.getWordList()+".txt";
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			int size = wordList.getSize();
			bw.write(wordList.getOffset()+" "+wordList.getSize()+" "+wordList.getRight()+" "+wordList.getRecite()+"\n");
			for (int i = 0; i < size; i++) {
				Word word = (Word) wordList.getCurWord(i);
				bw.write(word.getEnglsh()+" "+word.getChinese()+" "+word.getRight()+" "+word.getTotal() + "\n");
			}
			bw.close();
			//System.out.println("find document " + fileName);
			
		}catch(IOException exception){
			//System.out.println("cannot find document");
		}
		return fileName;
	}
}
