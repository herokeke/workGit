package common.spring.spring_ioc.annotation.ext;

import org.springframework.stereotype.Controller;

@Controller
public class OnePulgin implements Plugin {

	@Override
	public void excute() {
		System.out.println("第一个插件");

	}

}
