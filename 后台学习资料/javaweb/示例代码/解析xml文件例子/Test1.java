/*
 * Created on 2007-7-7
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test.com.ibm.crl.vepConnector;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ibm.crl.vepConnector.Configration;
import com.ibm.crl.vepConnector.VEPConnector;

/**
 * @author ForestHuo
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Test {
	public static void main(String[] args){
		try{
			Configration configration = new Configration("VEPConnectorConfigration.xml");
			VEPConnector vepConnector = configration.getVEPConnector();
			Document doc = vepConnector.get("api/entries/533abd39-fd89-4641-852c-69cbda623cb1");
			Element entry = doc.getRootElement();
			
			System.err.println(entry.attributeValue("title"));
			
			Element detail = entry.element("detail");
			String cdata = detail.getData().toString();
			
			Document detaildoc = DocumentHelper.parseText(cdata);
			Element userprofile = detaildoc.getRootElement();
			Element user_id = userprofile.element("user_id");
			System.err.println(user_id.getText());
			
			
			
//			Document userdoc = DocumentHelper.createDocument();
//			
//			Element user = userdoc.addElement("user");
//			user.addAttribute("id", "123");
//			user.addAttribute("email", "123@cn.ibm.com");
//			user.addAttribute("password", "123");
//			user.addAttribute("name", "123");
//			
//			user.addElement("company").addAttribute("id", "2cabd87a-d025-435c-be3c-533be409a852");
//			
//			Element detail = user.addElement("detail");
//			detail.addAttribute("typeId", "83727f2e-8685-450e-a253-f68cb65abfd6");
//			
//			Document cdata = DocumentHelper.createDocument();
//			Element userprofile = cdata.addElement("userprofile");
//			userprofile.addNamespace("", "http://vep.ibm.com/et/userprofile_0.1");
//			userprofile.addElement("user_id").addText("123");
//			userprofile.addElement("user_name").addText("123");
//			userprofile.addElement("password").addText("123");
//			
//			detail.addCDATA(cdata.asXML());
//			System.err.println(userdoc.asXML());
//			
//			Document result = vepConnector.add("api/users/", userdoc);
			
			
		}catch(Exception e){
			
		}
		
//		System.out.print("aaaa");
		
		
	}
}
