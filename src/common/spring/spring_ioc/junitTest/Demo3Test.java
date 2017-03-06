package common.spring.spring_ioc.junitTest;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import common.spring.spring_ioc.model.Boss;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:common/spring/spring_ioc/applicationContext.xml")
public class Demo3Test {
	
	private static ApplicationContext factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[]{"common/spring/spring_ioc/bean1.xml"});
		  factory = new ClassPathXmlApplicationContext(new String[]{"common/spring/spring_ioc/bean2.xml"},pFactory);
	}
	
	@Test
	public void testDemo(){
		Boss boss = (Boss) factory.getBean("boss");
		System.out.println(boss.getCar().getBrand());
	}

	
}
