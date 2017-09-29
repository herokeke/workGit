package common.junit;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//测试套件类 相当于测试类的集合
@RunWith(Suite.class)
@Suite.SuiteClasses({BasicClassTest1.class,BasicClassTest2.class})
public class SuiteTest {
    
	@org.junit.Test
	public void testFun() {
		assertEquals(2,new BasicClass().divide(6,3)); //断言 通过api 查看更多的断言。
	}

}
