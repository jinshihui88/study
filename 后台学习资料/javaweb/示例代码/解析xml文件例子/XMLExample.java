/*
 * Created on 2007-8-21
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test.com.ibm.crl.vepConnector;

//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Branch;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Document;

/**
 * @author User
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class XMLExample {

	public static void main(String[] args){
	   
		//System.out.println("++++++++++++++");
		
		try {
//			 //创建一个document
//			  Document document=(Document)DocumentHelper.createDocument();
//			  //创建根结点
//			  Element root=((Branch) document).addElement("root");
//			  //为根结点添加一个book节点
//			  Element book1=root.addElement("book");
//			  //为book1添加属性type
//			  book1.addAttribute("type","science");
//			  //为book1添加name子节点
//			  Element name1=book1.addElement("Name");
//			  //并设置其name为"Java"
//			  name1.setText("Java");
//			  //为book1创建一个price节点,并设其价格为100
//			  book1.addElement("price").setText("100");
//			  
//			  //为根结点添加第二个book节点，并设置该book节点的type属性
//			  Element book2=root.addElement("book").addAttribute("type","science");
//			  //为book1添加name子节点
//			  Element name2=book2.addElement("Name");
//			  //并设置其name为"Oracle"
//			  name2.setText("Oracle");
//			  //为book1创建一个price节点,并设其价格为200
//			  book2.addElement("price").setText("200");
//			  
//			  //输出xml
//			  System.out.println(((Node) document).asXML());
			
			//创建Document的基本操作
			
//			//create document
//			Document document=DocumentHelper.createDocument();
//			//add NodeElement:links
//			Element links=document.addElement("links");
//			//add element:link to NodeElemnt:links
//			Element link=links.addElement("link");
//			//add element:text to element:link
//			Element text=link.addElement("text");
//			//set the text to the element:text
//			text.setText("JSP Insider");
//            //add element:url to element:link
//			Element url=link.addElement("url");
//			//set the text to the element:url
//			url.setText("http://www.edusoft.com");
//			//add attribute:newWindow to the element:url
//			url.addAttribute("newWindow","no");
//			//add element:author to the element:link
//			Element author=link.addElement("author");
//			//add text to the element:author
//			author.setText("edu soft");
//			//add element:date to the element:link
//			Element date=link.addElement("date");
//			//add element:day to the element:date
//			Element day=date.addElement("day");
//			day.setText("2");
//			//add element:month to the element:date
//			Element month=date.addElement("month");
//			month.setText("1");
//			//add element:year to the element:date
//			Element year=date.addElement("year");
//			year.setText("2001");
//			//add element:description to the element:link
//			Element description=link.addElement("description");
//			description.setText("A edu information site.");
//			
//			//add the seconde element link2 to the NodeElement:links
//			Element link2=links.addElement("link");
//            //add element:text to element:link
//			Element text2=link2.addElement("text");
//			//set the text to the element:text
//			text2.setText("The nakers of Java");
//            //add element:url to element:link
//			Element url2=link2.addElement("url");
//			//set the text to the element:url
//			url2.setText("http://java.sun.com");
//			//add attribute:newWindow to the element:url
//			url2.addAttribute("newWindow","no");
//			//add element:author to the element:link
//			Element author2=link2.addElement("author");
//			//add text to the element:author
//			author2.setText("Sun Microsystems");
//			//add element:date to the element:link
//			Element date2=link2.addElement("date");
//			//add element:day to the element:date
//			Element day2=date2.addElement("day");
//			day2.setText("3");
//			//add element:month to the element:date
//			Element month2=date2.addElement("month");
//			month2.setText("1");
//			//add element:year to the element:date
//			Element year2=date2.addElement("year");
//			year2.setText("2001");
//			//add element:description to the element:link
//			Element description2=link2.addElement("description");
//			description2.setText("Sun Microsystem's website.");
//			
//			//add the third element:link the NodeElement:links
//			Element link3=links.addElement("link");
//            //add element:text to element:link
//			Element text3=link3.addElement("text");
//			//set the text to the element:text
//			text3.setText("The standard JSP container");
//            //add element:url to element:link
//			Element url3=link3.addElement("url");
//			//set the text to the element:url
//			url3.setText("http://jakarta.apache.org");
//			//add attribute:newWindow to the element:url
//			url3.addAttribute("newWindow","no");
//			//add element:author to the element:link
//			Element author3=link3.addElement("author");
//			//add text to the element:author
//			author3.setText("Apache Group");
//			//add element:date to the element:link
//			Element date3=link3.addElement("date");
//			//add element:day to the element:date
//			Element day3=date3.addElement("day");
//			day3.setText("4");
//			//add element:month to the element:date
//			Element month3=date3.addElement("month");
//			month3.setText("1");
//			//add element:year to the element:date
//			Element year3=date3.addElement("year");
//			year3.setText("2001");
//			//add element:description to the element:link
//			Element description3=link3.addElement("description");
//			description3.setText("Some great software.");
//			
//			System.err.println(document.asXML());
			
			//根据一个符合Document格式的字符串来生成一个Document
//			String str="<links><link><text>JSP Insider</text><url newWindow='no'>http://www.edusoft.com</url><author>edu soft</author><date><day>2</day><month>1</month><year>2001</year></date><description>A edu information site.</description></link><link><text>The nakers of Java</text><url newWindow='no'>http://java.sun.com</url><author>Sun Microsystems</author><date><day>3</day><month>1</month><year>2001</year></date><description>Sun Microsystem's website.</description></link><link><text>The standard JSP container</text><url newWindow='no'>http://jakarta.apache.org</url><author>Apache Group</author><date><day>4</day><month>1</month><year>2001</year></date><description>Some great software.</description></link></links>";
//		    Document document=DocumentHelper.parseText(str);
//		    System.err.println(document.asXML());
			
			//取得xml节点,属性的基本方法(利用迭代，xpath取得节点及其属性值,需要添加支持xpath的jar包)
			//利用xpath的话，可以取得某一具体节点，而不用操作所有的节点
			String str="<links><link><text>JSP Insider</text><url newWindow='no'>http://www.edusoft.com</url><author>edu soft</author><date><day>2</day><month>1</month><year>2001</year></date><description>A edu information site.</description></link><link><text>The nakers of Java</text><url newWindow='no'>http://java.sun.com</url><author>Sun Microsystems</author><date><day>3</day><month>1</month><year>2001</year></date><description>Sun Microsystem's website.</description></link><link><text>The standard JSP container</text><url newWindow='no'>http://jakarta.apache.org</url><author>Apache Group</author><date><day>4</day><month>1</month><year>2001</year></date><description>Some great software.</description></link></links>";
     	    Document document=DocumentHelper.parseText(str);
     	  //System.err.println(document.asXML());
     	    
     	    //get the root node:links
     	    Element root=document.getRootElement();
     	 // System.err.println(root.asXML()); 
     	    
			//get the node:link about the node:root
//     	    Element firNode=root.element("link");
//     	    System.err.println(firNode.asXML());
     	    
     	    //get the nodes about the rootNode:links
//     	   List list=new ArrayList();
//     	   list=root.elements();
//     	   for(int i=0;i<list.size();i++){
//     	     System.err.println("the value of i is:"+i);
//     	   	 Element node=(Element) list.get(i);
//     	     System.err.println(node.asXML());
//     	     
//     	     //get the nodes about the each node:link
//     	     Element node1=node.element("text");
//     	     System.out.println(node1.asXML());
//     	     Element node2=node.element("url");
//     	     System.out.println(node2.asXML());
//     	     System.out.println(node.element("author").asXML());
//     	     System.out.println(node.element("date").asXML());
//     	     System.out.println(node.element("description").asXML());
//     	     
//     	     //get the text of the node:text
//     	     System.err.println("the name of the node is:"+node1.getName());
//     	     System.err.println("the text is:"+node1.getText());
//     	     System.err.println("the text about trim is:"+node1.getTextTrim());
//     	     
//     	     //get the attribute about the node:url
//     	     System.err.println("the name of the node is:"+node2.getName());
//     	     System.err.println("the attribute is:"+node2.attribute(0));
//     	     System.err.println("the attribute is:"+node2.attribute("newWindow"));
//     	     System.err.println("the value is:"+node2.attributeValue("newWindow"));
//     	   }
     	    
     	    //将两个Document合并为一个Document
              
     	    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
