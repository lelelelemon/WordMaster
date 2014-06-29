package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


//下面主要是org.xml.sax包的类
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
		// （1）得到DOM解析器的工厂实例
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		ArrayList<InterfaceOfWord> allword = new ArrayList<InterfaceOfWord>();
		// 得到javax.xml.parsers.DocumentBuilderFactory;类的实例就是我们要的解析器工厂
		try {
			// （2）从DOM工厂获得DOM解析器
			DocumentBuilder dombuilder = domfac.newDocumentBuilder();
			// 通过javax.xml.parsers.DocumentBuilderFactory实例的静态方法newDocumentBuilder()得到DOM解析器
			// （3）把要解析的XML文档转化为输入流，以便DOM解析器解析它
			InputStream is = new FileInputStream("dictionary.xml");
			// （4）解析XML文档的输入流，得到一个Document
			Document doc = dombuilder.parse(is);
			// 由XML文档的输入流得到一个org.w3c.dom.Document对象，以后的处理都是对Document对象进行的
			// （5）得到XML文档的根节点
			Element root = doc.getDocumentElement();
			// 在DOM中只有根节点是一个org.w3c.dom.Element对象。
			// （6）得到节点的子节点
			NodeList books = root.getChildNodes();

			ArrayList<Word> alllist = new ArrayList<Word>();
			if (books != null) {
				for (int i = 0; i < books.getLength(); i++) {
					Node book = books.item(i);
					if (book.getNodeType() == Node.ELEMENT_NODE) {
						// （7）取得节点的属性值
						// String
						// email=book.getAttributes().getNamedItem("email").getNodeValue();
						// System.out.println(email);
						// 注意，节点的属性也是它的子节点。它的节点类型也是Node.ELEMENT_NODE
						// （8）轮循子节点
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
				}// （6）这是用一个org.w3c.dom.NodeList接口来存放它所有子节点的，还有一种轮循子节点的方法，后面有介绍
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