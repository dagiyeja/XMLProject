/*
 * xml�� �Ľ��ϴ� ������� ũ�� 2������ �ִ�
 * 1.SAX �Ľ� -�ַ� ����, �����
 *  -xml�� �̷�� �±װ� �߰ߵɶ����� ������ �̺�Ʈ�� �߻�����������, �����ڰ� 
 *  ������ Ÿ�ֿ̹� ���� �����͸� �ؼ��ϴ� ���
 *  
 *  2.DOM(Document Object Model) �Ľ� 
 *  SGML���� �¾ HTML, XML�� ���α׷� �� �ƴϱ� ������, javascript, java ��
 *  �Ϲ��� ���α׷��� ���� ������ �� �ִ� �������� �����ؾ� �Ѵ�.. �̿� ����
 *  HTML, XML�� ������ �� �� �±� ��Ҹ��� 1:1�����ϴ� ��ü�� �޸𸮿� �÷� ������ �� �ֵ���
 *  �����Ǵ� API ������ ��Ʋ�� DOM�̶� �Ѵ�..
 *  �޸� ȿ���� ������� ����
 *  
 * �ᱹ ���ڹ����� ���α׷� ���� �����Ϸ��� ��üȭ(����, �޼���) �Ǿ� �־�� �Ѵ�..
 * 
 * Ư�� ����Ʈ���� ���� ���� �ܸ���� �޸𸮰� ������ �����ϹǷ�, �޸� ȿ������ ���ؼ��� DOM���ٴ� SAX ����� �е������� ���� ����
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
		//�ڹ� ���� SAX ����� �Ľ��� �õ��Ϸ��� 
		//SAX Parser�� �ʿ��ϴ�..
		//java SE  �ļ��� ���ԵǾ� �ִ�.. �������� xml�� ���ø����̼� ���߽� ���� ���δ�
		
		//�߻�Ŭ������ �ν��Ͻ� �� �����
		//���� ���丮 ��ü�κ��� �ν��Ͻ��� ���;� �Ѵ�..
		//���丮 ��ü�� �߻�Ŭ����->����ƽ �޼��� ���� ����
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
