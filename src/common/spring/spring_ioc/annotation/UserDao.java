package common.spring.spring_ioc.annotation;

import org.springframework.stereotype.Controller;

@Controller("userDao")
public class UserDao implements IDao {
   
	public void addUser(){
		System.out.println("添加人员");
	}
}
