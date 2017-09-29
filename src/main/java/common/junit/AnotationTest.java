package common.junit;


import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class AnotationTest {


	@Test(expected=ArithmeticException.class) //预期会有异常抛出。有异常则通过 没有则失败。
	public void testFun() {
		assertEquals(2,new BasicClass().divide(6,3));
	}
	
	
 //	@RunWith() 更改测试运行器  org.junit.runner.Runner;
	@Ignore  //被测试器忽略掉
	@Test(timeout=1)
	public void testTimeOut(){
		int i = 0;
		while(true){
			i++;
			System.out.println("TimeOut"+i);
		}
	}
	
}
