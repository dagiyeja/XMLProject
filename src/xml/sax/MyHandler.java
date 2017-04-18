/*
 * DOM����� �ļ��� ��ġ javascript���� DOM��ü �����ϵ���, 
 * �޸𸮿� �÷��� ��ü�� ���ϴ� id�� �±׸� �����ε� 
 * ���ϴ� ������ �ƹ����� ������ �� ������,
 * SAX����� �ļ��� �ڽ��� �ؼ��Ϸ��� xml ������ �̷�� 
 * �±װ� �߰ߵɶ����� �̺�Ʈ�� ����Ű�� ������
 * �� �̺�Ʈ Ÿ�̹��� ��ġ��, xml ��ҿ� ������ �� ����.. 
 * ���� �� �̺�Ʈ�� �Ͼ �� � ó���� ����� ������ �����ϴ� ��ü��
 * DefaultHandler��� Ŭ������ �������ش�..
 * */

package xml.sax;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	int count;

	
	public void startDocument() throws SAXException {
		System.out.println("������ �����Դϴ�!!");
		
	}
	
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("<"+qName+">"); //qNmae->�±� 
		
		
	}
	
	//�±׿� �±� ������ �ؽ�Ʈ�� �߰ߵǸ� ȣ���!!	
	public void characters(char[] ch, int start, int length) throws SAXException {
		count++;
		System.out.println(new String(ch,start,length));
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">"); //qNmae->�±� 
	}
	
	public void endDocument() throws SAXException {
		System.out.println("������ ���Դϴ�.");
	
	}
}
