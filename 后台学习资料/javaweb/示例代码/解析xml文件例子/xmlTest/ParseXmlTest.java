package xmlTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ParseXmlTest {
	public static void main(String[] args){
		
		//解析xml文件内容：
		/*
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("D:/workspace/servletExam1/src/xmlTest/test1.xml"));
			//Document doc = reader.read(new File("/servletExam1/xmlTest/test1.xml"));
			
			Element root = doc.getRootElement();
			System.out.println("root name is: " + root.getName());
			
			Iterator it = root.elementIterator();
			while(it.hasNext()){
				Element child = (Element) it.next();
				System.out.println("======================================");
				System.out.println("name: " + child.getName() + ",  " + child.getTextTrim());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//生成xml文件：
		/*
		try {
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("students");
			Element student = root.addElement("student");
			Element name = student.addElement("name");
			
			FileWriter fw = new FileWriter(new File("F:/aTemp/stus.xml"));
			doc.write(fw);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//修改xml文件：
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("D:/workspace/servletExam1/src/xmlTest/test3.xml"));
			//Document doc = reader.read(new File("/servletExam1/xmlTest/test1.xml"));
			
			System.out.println("name :" + doc.getName() + ", nodeType: " + doc.getName() + ", typeName: " + doc.getNodeTypeName());
			Element root = doc.getRootElement();
			Iterator it = root.elementIterator();
			while(it.hasNext()){
				Element child = (Element) it.next();
				System.out.println("======================================");
				System.out.println("name: " + child.getName() + ",  " + child.getNodeTypeName() + ",  " + child.getText());
				
				List l = child.elements();
				for(int i=0; i<l.size(); i++){
					Element ee = (Element) l.get(i);
					System.out.println(ee.getName() + ",  " + ee.getNodeType() + ",  " + ee.getNodeTypeName());
					
					ee.setText("28");
				}
			}
			
			FileWriter fw = new FileWriter(new File("F:/aTemp/stusTest3.xml"));
			//OutputFormat outFormat = OutputFormat.createPrettyPrint();
			//XMLWriter xw = new XMLWriter(fw, outFormat);
			doc.write(fw);
			fw.flush();
			fw.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
