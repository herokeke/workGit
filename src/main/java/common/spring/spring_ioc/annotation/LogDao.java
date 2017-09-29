package common.spring.spring_ioc.annotation;

import org.springframework.stereotype.Controller;

@Controller
public class LogDao {

	public void addLog(){
		System.out.println("添加日志");
	}
}
