package gofmodel.Command;

import org.junit.Test;

/**
 * 命令模式
 *         例子： 遥控器通过命令控制电视。
 *         
 * @author Administrator
 *
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
