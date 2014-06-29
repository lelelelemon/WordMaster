package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


//������Ҫ��org.xml.sax������
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import InterfaceOfModel.InterfaceOfWord;
import Model.*;

/* 0 - n
 * 1 - v
 * 2 - adv
 * 3 - adj
 * 4 - num
 * 5 - prep
 * 6 - pron
 * */
public class DomParse {

	public ArrayList<InterfaceOfWord> DomParse() {
		// ��1���õ�DOM�������Ĺ���ʵ��
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		ArrayList<InterfaceOfWord> allword = new ArrayList<InterfaceOfWord>();
		// �õ�javax.xml.parsers.DocumentBuilderFactory;���ʵ����������Ҫ�Ľ���������
		try {
			// ��2����DOM�������DOM������
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
			// ͨ��javax.xml.parsers.DocumentBuilderFactoryʵ���ľ�̬����newDocumentBuilder()�õ�DOM������
			// ��3����Ҫ������XML�ĵ�ת��Ϊ���������Ա�DOM������������
			InputStream is = new FileInputStream("dictionary.xml");
			// ��4������XML�ĵ������������õ�һ��Document
			Document doc = dombuilder.parse(is);
			// ��XML�ĵ����������õ�һ��org.w3c.dom.Document�����Ժ�Ĵ����Ƕ�Document������е�
			// ��5���õ�XML�ĵ��ĸ��ڵ�
			Element root = doc.getDocumentElement();
			// ��DOM��ֻ�и��ڵ���һ��org.w3c.dom.Element����
			// ��6���õ��ڵ���ӽڵ�
			NodeList books = root.getChildNodes();

			ArrayList<Word> alllist = new ArrayList<Word>();
			if (books != null) {
				for (int i = 0; i < books.getLength(); i++) {
					Node book = books.item(i);
					if (book.getNodeType() == Node.ELEMENT_NODE) {
						// ��7��ȡ�ýڵ������ֵ
						// String
						// email=book.getAttributes().getNamedItem("email").getNodeValue();
						// System.out.println(email);
						// ע�⣬�ڵ������Ҳ�������ӽڵ㡣���Ľڵ�����Ҳ��Node.ELEMENT_NODE
						// ��8����ѭ�ӽڵ�
						String english = null;
						String chinese = null;
						for (Node node = book.getFirstChild(); node != null; node = node
								.getNextSibling()) {
							
							int[] type;
							if (node.getNodeType() == Node.ELEMENT_NODE) {
								if (node.getNodeName().equals("english")) {
									// String name=node.getNodeValue();
									english = node.getFirstChild()
											.getNodeValue();

								}
								int j = 0;
								String chinArr[] = null;
								if (node.getNodeName().equals("chinese")) {
									chinese = node.getFirstChild()
											.getNodeValue();
									chinArr = chinese.split("[.]");
									for (j = 0; j < chinArr.length; j++) {
										if (chinArr[j].length() == 0)
											break;
										if (chinArr[j].charAt(0) != 44)
											if (chinArr[j].charAt(0) > 122
													|| chinArr[j].charAt(0) < 97)
												break;
										chinArr[j] = chinArr[j]
												.replace(",", "");
										//System.out.println(chinArr[j]);

									}
									//System.out.println(j);
									type = new int[j];
									for (int n = 0; n < j; n++) {
										if (chinArr[n].equals("n")) {
											type[n] = 0;
										}
										//v.aux
										else if (chinArr[n].equals("v")) {
											if(chinArr[n+1].equals("aux")){
												type[n] = 9;
												n += 1;
												System.out.println(chinese);
												continue;
											}
											type[n] = 1;
										}
										else if (chinArr[n].equals("adv") || chinArr[n].equals("ad")) {
											type[n] = 2;
										}
										else if (chinArr[n].equals("adj")) {
											type[n] = 3;
										}
										else if (chinArr[n].equals("num")) {
											type[n] = 4;
										}
										else if (chinArr[n].equals("prep")) {
											type[n] = 5;
										}
										else if (chinArr[n].equals("pron")) {
											type[n] = 6;
										}
										else if (chinArr[n].equals("int")) {
											type[n] = 7;
										}
										else if (chinArr[n].equals("conj")) {
											type[n] = 8;
										}
								
										else{
											System.out.println(chinArr[n] + " " + chinese);
										}
										Word word = new Word(english, chinese, type[n]);
										allword.add(word);
										//System.out.println("type is " + type[n]);
									}
									
								}

							}
						}
					}
				}// ��6��������һ��org.w3c.dom.NodeList�ӿ�������������ӽڵ�ģ�����һ����ѭ�ӽڵ�ķ����������н���
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allword;
	}

	public static void main(String[] args) {
		DomParse dp = new DomParse();
		ArrayList<InterfaceOfWord> words = dp.DomParse();
		System.out.println(words.size());
		for(int i = 0 ; i < words.size(); i ++){
			if(words.get(i).getWordList() == 9){
				System.out.println("chinese is " + words.get(i).getChinese());
				System.out.println("english is " + words.get(i).getEnglsh());
				System.out.println("type is " + words.get(i).getWordList());
			}
		}
		 
	}
}