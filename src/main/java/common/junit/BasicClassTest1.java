package common.junit;


import static org.junit.Assert.*;

import org.junit.Test;

public class BasicClassTest1 {

	@Test
	public void testFun() {
		assertEquals(2,new BasicClass().divide(6,3)); //断言 通过api 查看更多的断言。
	}

}
