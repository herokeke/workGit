package gofmodel.Command;

import org.junit.Test;

/**
 * 命令模式
 *         例子： 遥控器通过命令控制电视。
 *         
 * @author Administrator
 *
 *定义：将一个请求封装为一个对象，从而是你可以用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可取消的操作。
 *说明：将请求的发送者与请求的接收者分离，通过抽象编程的方式，使得相同的请求发送可以作用于不同的请求接收者。
 *频率：4
 */
public class CommandTest {
	
	@Test
	public void testCommand(){
		
		//创建电视
		Television tv = new Television();
		//命令实现
		Command coff = new CommandOff(tv);
		//命令实现
		Command con = new CommandOn(tv);
		//创建遥控器
		Control control = new Control();
		//注入命令
		control.setCommand(con);
		control.setCommand(coff);
		//操作执行
		control.turn();
		control.removeCommand(con);
		control.turn();
		
	}

}
