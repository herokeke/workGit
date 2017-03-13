package common.spring.spring_ioc.annotation.ext;

import org.springframework.stereotype.Controller;

import common.spring.spring_ioc.annotation.IDao;


@Controller("extUserDao")
public class UserDao implements IDao{
   
	public void addUser(){
		System.out.println("添加扩展人员");
	}
}
