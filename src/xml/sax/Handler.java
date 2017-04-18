/*
 * tag나 각종 데이터 발견시 이벤트 발생시키는 객체
 * */
package xml.sax;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	MyModel model;
	
	//실행부가 어느 태그 위치에 와 있는지 여부를 체크하는 변수
	boolean member;
	boolean name;
	boolean age;
	boolean gender;
	
	Vector vec;
	
	public Handler(MyModel model) {
		this.model=model;
	}
	
	//<시작 태그>가 발견되면 호출되는 메서드
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//시작 태그 중 <member> 태그가 발견되면, 
		//Vector를 생성하자!!
		//member를 잡아냄-> 발견하면 벡터를 생성한다
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


	//텍스트가 발견되면 호출되는 메서드
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(name){		//실행부가 name에 도달하면
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
	
	//<닫는 태그>가 발견되면 호출되는 메서드 
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("member")){
			model.data.add(vec);
		}
	}
	
	public void endDocument() throws SAXException {
		System.out.println("담겨진 총 명수는 "+model.data.size());
	}
}
