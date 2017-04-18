/*
 * DOM방식의 파서는 마치 javascript에서 DOM객체 접근하듯이, 
 * 메모리에 올려진 객체를 원하는 id나 태그명 만으로도 
 * 원하는 시점에 아무때나 접근할 수 있지만,
 * SAX방식의 파서는 자신이 해석하려는 xml 파일을 이루는 
 * 태그가 발견될때마다 이벤트만 일으키기 때문에
 * 이 이벤트 타이밍을 놓치면, xml 요소에 접근할 수 없다.. 
 * 따라서 이 이벤트가 일어날 때 어떤 처리를 해줘야 할지를 관리하는 객체를
 * DefaultHandler라는 클래스로 제공해준다..
 * */

package xml.sax;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	int count;

	
	public void startDocument() throws SAXException {
		System.out.println("문서의 시작입니다!!");
		
	}
	
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("<"+qName+">"); //qNmae->태그 
		
		
	}
	
	//태그와 태그 사이의 텍스트가 발견되면 호출됨!!	
	public void characters(char[] ch, int start, int length) throws SAXException {
		count++;
		System.out.println(new String(ch,start,length));
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">"); //qNmae->태그 
	}
	
	public void endDocument() throws SAXException {
		System.out.println("문서의 끝입니다.");
	
	}
}
