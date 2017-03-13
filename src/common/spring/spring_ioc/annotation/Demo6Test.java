package common.spring.spring_ioc.annotation;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:common/spring/spring_ioc/applicationContext6.xml")
public class Demo6Test extends AbstractJUnit4SpringContextTests {

    @Resource
    private LogonService logonService;

	@Test
	public void testDemo(){
	//	logonService.excute();
	//	logonService.plugin();
	}	
}
