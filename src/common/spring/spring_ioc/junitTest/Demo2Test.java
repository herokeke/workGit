package common.spring.spring_ioc.junitTest;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.spring.spring_ioc.model.Boss;
import common.spring.spring_ioc.model.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:common/spring/spring_ioc/applicationContext.xml")
public class Demo2Test {

	
	@Resource(name="car")
	private Car car;

	@Test
	public void testDemo(){
		//Boss bos = (Boss) applicationContext.getBean("boss");
		System.out.println(car.getBrand()+car.getSpeed());
		
	}

	
	
}
