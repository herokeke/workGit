package common.spring.spring_transaction.demo5;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:common/spring/spring_transaction/demo5/applicationContext.xml")
public class demo5Test {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	
	@Test
	public void testDemo(){
		//aa给bb转账200元
		accountService.transfer("aa", "bb", 200d);
	}
}
