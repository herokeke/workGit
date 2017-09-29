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
@ContextConfiguration("classpath:common/spring/spring_ioc/applicationContext4.xml")
public class Demo4Test extends AbstractJUnit4SpringContextTests {

	
	@Resource(name="boss")
	private Boss boss;

	@Test
	public void testDemo(){
	
		Set<String> set = boss.getPropSet();
		for( String pro : set){
			System.out.println(pro);
		}
	}
	
}
