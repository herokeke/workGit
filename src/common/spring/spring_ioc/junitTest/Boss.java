package common.spring.spring_ioc.junitTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import common.spring.spring_ioc.annotation.Car;



@Component
public class Boss {

	private Car car;
	
	public Boss(){
		System.out.println("construt...");
	}
	
	@Autowired
	private void setCar(Car car){
		System.out.println("setCar");
		this.car = car;
	}
	
	@PostConstruct
	private void init1(){
		System.out.println("init1");
	}
	@PostConstruct
    private void init2(){
    	System.out.println("init2");
	}
    @PreDestroy
    private void destroy1(){
    	System.out.println("destroy1");
	}
    @PreDestroy
    private void destroy2(){
    	System.out.println("destroy2");
 	}
	
	public static void main(String[] args){
		//启动容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:common/spring/spring_ioc/applicationContext6.xml");
		// 关闭容器
		((ClassPathXmlApplicationContext)ctx).destroy();
		
		/*
		construt...
		setCar
		init1
		init2
		destroy1
		destroy2
		*/
	}
	
}
