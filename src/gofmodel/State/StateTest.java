package gofmodel.State;

import org.junit.Test;

/**
 * 状态模式
 *       将多个IF判断 转换为实现类，通过实现类中hundle 进行有序调用，直到程序执行成功。
 * @author Administrator
 *定义：允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它所属的类。
 *说明：对象状态不同时其行为也不相同，而且对象对象的状态可以发生转换。
 *频率：3
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
