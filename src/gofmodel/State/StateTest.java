package gofmodel.State;

import org.junit.Test;

/**
 * 状态模式
 *       将多个IF判断 转换为实现类，通过实现类中hundle 进行有序调用，直到程序执行成功。
 * @author Administrator
 *
 */
public class StateTest {
	
	@Test
	public void testState(){
		Person p = new Person();
		
		p.setHour(6);
		p.handle();
		
		p.setHour(12);
		p.handle();
		
		p.setHour(18);
		p.handle();
		
		p.setHour(12);
		p.handle();
		
		p.setHour(18);
		p.handle();
		
		p.setHour(6);
		p.handle();
		
	}

}
