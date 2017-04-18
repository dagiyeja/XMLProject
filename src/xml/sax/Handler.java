/*
 * tag�� ���� ������ �߽߰� �̺�Ʈ �߻���Ű�� ��ü
 * */
package xml.sax;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	MyModel model;
	
	//����ΰ� ��� �±� ��ġ�� �� �ִ��� ���θ� üũ�ϴ� ����
	boolean member;
	boolean name;
	boolean age;
	boolean gender;
	
	Vector vec;
	
	public Handler(MyModel model) {
		this.model=model;
	}
	
	//<���� �±�>�� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//���� �±� �� <member> �±װ� �߰ߵǸ�, 
		//Vector�� ��������!!
		//member�� ��Ƴ�-> �߰��ϸ� ���͸� �����Ѵ�
		if(qName.equalsIgnoreCase("member")){
			vec=new Vector();
			member=true;
		}
		if(qName.equalsIgnoreCase("name")){
			name=true;
		}
		if(qName.equalsIgnoreCase("age")){
			age=true;
		}
		if(qName.equalsIgnoreCase("gender")){
			gender=true;
		}
	}


	//�ؽ�Ʈ�� �߰ߵǸ� ȣ��Ǵ� �޼���
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(name){		//����ΰ� name�� �����ϸ�
			vec.add(new String(ch, start, length));
			name=false;
		}else if(age){		
			vec.add(new String(ch, start, length));
			age=false;
		}else if(gender){		
			vec.add(new String(ch, start, length));
			gender=false;
		}
	}
	
	//<�ݴ� �±�>�� �߰ߵǸ� ȣ��Ǵ� �޼��� 
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("member")){
			model.data.add(vec);
		}
	}
	
	public void endDocument() throws SAXException {
		System.out.println("����� �� ����� "+model.data.size());
	}
}
