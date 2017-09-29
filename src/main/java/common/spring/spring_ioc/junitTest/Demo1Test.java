package common.spring.spring_ioc.junitTest;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.spring.spring_ioc.model.Boss;
import common.spring.spring_ioc.model.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:common/spring/spring_ioc/applicationContext1.xml")
public class Demo1Test extends AbstractJUnit4SpringContextTests {

	
	@Resource(name="boss")
	private Boss boss;

	@Test
	public void testDemo(){
		 System.out.println((ArrayList)boss.getPropList());
		//System.out.println((LinkedList)boss.getPropList()); //java.lang.ClassCastException: java.util.ArrayList cannot be cast to java.util.LinkedList
		List<String> list = boss.getPropList();
		for( String pro : list){
			System.out.println(pro);
		}
		
		Set<String> set = boss.getPropSet();
		for( String pro : set){
			System.out.println(pro);
		}
		
		Map<String,Object> map = boss.getPropMap();
		for(String key: map.keySet()){
			System.out.println(key+":"+map.get(key));
			
		}
		
		 Enumeration enukey = boss.getProperties().propertyNames();  
	        while (enukey.hasMoreElements()) {  
	            Object key = enukey.nextElement();  
	            System.out.println(key);  
	        }  
	        
	        Enumeration<Object> enuValue = boss.getProperties().elements();  
	        while (enuValue.hasMoreElements()) {  
	            Object value = enuValue.nextElement();  
	            System.out.println(value);  
	        }  
	        
	        Iterator<Entry<Object, Object>> it = boss.getProperties().entrySet().iterator();  
	        while (it.hasNext()) {  
	            Entry<Object, Object> entry = it.next();  
	            Object key = entry.getKey();  
	            Object value = entry.getValue();  
	            System.out.println("key   :" + key);  
	            System.out.println("value :" + value);  
	            System.out.println("---------------");  
	        }  
		
	}

	
	
}
