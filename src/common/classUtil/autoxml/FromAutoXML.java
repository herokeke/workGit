package common.classUtil.autoxml;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.xml.sax.InputSource;


public class FromAutoXML {  
	public List<Map<String,String>> formatXml2Table(String xmlString,String type) throws Exception
	{
		SAXBuilder builder = new SAXBuilder();
	    StringReader read = new StringReader(xmlString);
	    InputSource source = new InputSource(read);
	    Document doc = builder.build(source);
		Element rootEle = doc.getRootElement();
		List table = new ArrayList();
		List<Element> recordEleList = rootEle.getChildren("recordInfo");
		Map fieldInfoMap = new LinkedHashMap();
		for(Element recordEle : recordEleList)
		{
			List<Element> fieldEleList = recordEle.getChildren(type); //fieldInfo, userInfo, devices
			for(Element fieldEle : fieldEleList){
				Map row = new LinkedHashMap();
				if("fieldInfo".equals(type)){
					String enName = loadNodeValue(fieldEle, KeyType.CHILDTEXT, "fieldEnName", true, "");
					String value = loadNodeValue(fieldEle, KeyType.CHILDTEXT, "fieldContent", false, "");
					fieldInfoMap.put(enName, value);
				}else{
					List<Element> fieldEleLifieldEleListus =fieldEle.getChildren("fieldInfo");
					for(Element fieldEles : fieldEleLifieldEleListus){
					String enName = loadNodeValue(fieldEles, KeyType.CHILDTEXT, "fieldEnName", true, "");
					String value = loadNodeValue(fieldEles, KeyType.CHILDTEXT, "fieldContent", false, "");
					row.put(enName, value);
					}
					table.add(row);
				}
			}
		}
		table.add(fieldInfoMap);
		return table;
	}
	private String loadNodeValue(Element ele, KeyType type, String key, boolean require, String defaultValue) throws Exception
	{
		String value = defaultValue;
		String ele_String = "";
		try
		{
			if(type.equals(KeyType.ATTRIBUTE)) ele_String = ele.getAttributeValue(key);
			else ele_String = ele.getChildTextTrim(key);
		}
		catch (Exception e)
		{
			if(require && value.equals(""))
			{
				throw e;
			}
		}
		if(!ele_String.equals("")) value = ele_String;
		return value;
}
	private enum KeyType {ATTRIBUTE, CHILDTEXT}
	
	
	public static Format FormatXML(){  
		        Format format = Format.getCompactFormat();  
		        format.setEncoding("utf-8");  
		        format.setIndent(" ");  
		return format;  
		    }  
	
	public static void main(String[] args){
		FromAutoXML fax  =new FromAutoXML();
		String[] param  = new String[]{"fieldInfo", "userInfo", "devices"};
		Reader  r = null;
		StringBuffer sbf = new StringBuffer();
		for(String str : param){
			try {
			    r= new FileReader("D:\\admin\\workspace\\Test\\src\\com\\cmbc\\www\\jfjc.xml");  
			    int b = 0;
				while ((b = r.read()) != -1) {
					sbf.append((char)b);
				}
				System.out.println(sbf.toString());
				List<Map<String,String>> ls=  fax.formatXml2Table(sbf.toString(), str);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}  
