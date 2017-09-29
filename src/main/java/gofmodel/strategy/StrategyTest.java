package gofmodel.strategy;

import org.junit.Test;

/**
 * 策略模式
 *        定义一个接口  多个实现类 调用根据需求传入不通的class。
 *        类似MVC3层架构 或 JDBC 调用 Oracle MySQL 都应该属于策略模式。
 * @author Administrator
 * 
 * 定义：一系列的算法，把它们一个个封装起来，并且使他们可以相互替换。本模式使得算法的变化可独立于使用它的客户。
 * 说明：实现某功能存在多种方式，在不修改现有系统的基础上可以灵活选择或更换实现方式，也可以使用新的实现方式。
 * 频率：4
 *
 */
public class StrategyTest {
	
	@Test
	public void testStrategy(){
		Context m = new Context(new MysqlClient());
		m.connectDBase();
		
		Context o = new Context(new OracleClient());
		o.connectDBase();
		
	}
	

}
