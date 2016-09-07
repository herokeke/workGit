package common.classUtil.autoxml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class AutoXML {  
    
    private List<String> fruit = new ArrayList<String>();  
    public void initList(){  
        fruit.add("香蕉");  
        fruit.add("苹果");  
        fruit.add("橘子");  
        fruit.add("鸭梨");  
    }   
      
    public void BuildXML(){  
    	initList();
        Element root = new Element("opDetail");  
        Element recordInfo = new Element("recordInfo");
        Document Doc  = new Document(root);  
        String xmlString =null;
        root.addContent(recordInfo);  
        Map<String,String> map = new HashMap<String,String>();
	    map.put("BaseSummary","工单");
	    map.put("BaseDescrption","说明");
	    map.put("BaseCreateDate","时间");
	    map.put("Category","人员");
	    map.put("Type","类型");
	    map.put("Item","条码");
	    map.put("Request_Urgency","水电费");
	    map.put("Dealer","士大夫的身份");
        for(Iterator it = map.keySet().iterator();it.hasNext();){
        	String key = (String) it.next();
            Element fieldInfo = new Element("fieldInfo");  
            fieldInfo.addContent(new Element("fieldEnName").setText(key)); 
            fieldInfo.addContent(new Element("fieldChName").setText(map.get(key))); 
            fieldInfo.addContent(new Element("fieldContent").setText("阿桑地方"));  
            recordInfo.addContent(fieldInfo);  
        }
        for(int i = 0; i < 0; i++){ 
        	Element userInfo = new Element("userInfo");
        	recordInfo.addContent(userInfo);  
        	Element fieldInfo = new Element("fieldInfo");  
            fieldInfo.addContent(new Element("fieldEnName").setText("user"));  
            fieldInfo.addContent(new Element("fieldContent").setText(i*10+"元"));  
            userInfo.addContent(fieldInfo);  
        }
        for(int i = 0; i < 0; i++){ 
        	Element userInfo = new Element("devices");
        	recordInfo.addContent(userInfo);  
        	Element fieldInfo = new Element("fieldInfo");  
            fieldInfo.addContent(new Element("fieldEnName").setText("driver"));  
            fieldInfo.addContent(new Element("fieldContent").setText(i*10+"元"));  
            userInfo.addContent(fieldInfo);  
        }
       XMLOutputter XMLOut = new XMLOutputter(FormatXML());  
       //XMLOutputter XMLOut = new XMLOutputter();  
        xmlString = XMLOut.outputString(Doc);
        System.out.println(xmlString);
    }  
    public Format FormatXML(){  
        Format format = Format.getCompactFormat();  
        format.setEncoding("utf-8");  
        format.setIndent("");  
        return format;  
    }  
      
    public static void main(String[] args){  
        try{  
            AutoXML mXml = new AutoXML();  
            System.out.println("生成.....");  
            mXml.BuildXML();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
  
}  