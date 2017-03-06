package common.spring.spring_ioc.junitTest;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import common.spring.spring_ioc.model.Car;
import common.spring.spring_ioc.model.CarFactoryBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:common/spring/spring_ioc/applicationContext6.xml")
public class Demo6Test extends AbstractJUnit4SpringContextTests {


	@Resource(name="car")
	private Car car;

	@Test
	public void testDemo(){
		System.out.println(car.getBrand());
		System.out.println(car.getSpeed());
	}	
}
