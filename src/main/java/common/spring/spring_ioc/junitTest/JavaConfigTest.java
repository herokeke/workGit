package common.spring.spring_ioc.junitTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.spring.spring_ioc.annotation.IDao;
import common.spring.spring_ioc.annotation.LogDao;
import common.spring.spring_ioc.model.Car;

//通过@ImportResource引入xml配置文件
@ImportResource("classpath:common/spring/spring_ioc/applicationContext5.xml")
@Configuration
public class JavaConfigTest {
	// 自动注入xml文件中定义的Bean
	@Autowired
	public IDao getDao(LogDao logDao){
		return (IDao) logDao;
	}
	
	@Lazy
	@Scope("prototype")
	@Bean
	public Boss getBoss(){
		return new Boss();
	}

//	public static void main(String[] args){
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfigTest.class);
//		Boss boss = ctx.getBean(Boss.class);
//		boss.toString();
//		
//	}
	
	public static void main(String[] args){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// 注册多个@Configuration配置
		ctx.register(JavaConfigTest.class);
		ctx.register(JavaConfigTest.class);
		//刷新容器以应用这些注册的配置类
		ctx.refresh();
		Boss boss = ctx.getBean(Boss.class);
		boss.toString();
		
	}
}
