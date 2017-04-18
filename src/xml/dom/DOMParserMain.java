/*
 * xml문서가 로드될때마다, 태그와 1:1 대응하는 DOM 객체를 
 * 메모리에 올리는 방식으로, 스마트폰 개발에 있어서는
 * 메모리 문제상 피하는 것이 좋다..
 * */

package xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParserMain {
	public static void main(String[] args) {
		DocumentBuilderFactory factory=null;
		factory=DocumentBuilderFactory.newInstance();
		String path="C:/java_workspace2/XMLProject/data/member.xml";
		
		try {
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse(new File(path)); //파싱 시작!!
			/*
			NodeList nList=doc.getElementsByTagName("members");
			System.out.println(nList.getLength());
			*/
			/*
			NodeList nList=doc.getChildNodes();
			System.out.println(nList.getLength());
			*/
			/*
			NodeList nList=(NodeList) doc.getFirstChild();
			System.out.println(nList.getLength());
			*/
		
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
