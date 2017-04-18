/*
 * xml을 파싱하는 방법에는 크게 2가지가 있다
 * 1.SAX 파싱 -주로 쓰임, 권장됨
 *  -xml을 이루는 태그가 발견될때마다 적절한 이벤트를 발생시켜줌으로, 개발자가 
 *  적절한 타이밍에 맞춰 데이터를 해석하는 방식
 *  
 *  2.DOM(Document Object Model) 파싱 
 *  SGML에서 태어난 HTML, XML은 프로그램 언어가 아니기 때문에, javascript, java 등
 *  일반적 프로그래밍 언어에서 이해할 수 있는 형식으로 존재해야 한다.. 이에 따라
 *  HTML, XML이 실행할 때 각 태그 요소마다 1:1대응하는 객체를 메모리에 올려 제어할 수 있도록
 *  제공되는 API 집합을 통틀어 DOM이라 한다..
 *  메모리 효율상 권장되지 않음
 *  
 * 결국 전자문서는 프로그램 언어에서 제어하려면 객체화(변수, 메서드) 되어 있어야 한다..
 * 
 * 특히 스마트폰과 같은 소형 단말기는 메모리가 언제나 부족하므로, 메모리 효율성을 위해서는 DOM보다는 SAX 방식이 압도적으로 많이 쓰임
 * */


package xml.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseMain {

	public static void main(String[] args) {
		//자바 언어로 SAX 방식의 파싱을 시도하려면 
		//SAX Parser가 필요하다..
		//java SE  파서가 포함되어 있다.. 그정도로 xml은 어플리케이션 개발시 많이 쓰인다
		
		//추상클래스라서 인스턴스 못 만든다
		//따라서 팩토리 객체로부터 인스턴스를 얻어와야 한다..
		//팩토리 객체도 추상클래스->스태틱 메서드 통해 얻어옴
		SAXParserFactory factory=null;
		factory=SAXParserFactory.newInstance();
		String path="C:/java_workspace2/XMLProject/data/member.xml";
		
		try {
			SAXParser parser=factory.newSAXParser();
			parser.parse(new File(path), new MyHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
