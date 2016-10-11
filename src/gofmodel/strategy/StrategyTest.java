package gofmodel.strategy;

import org.junit.Test;

/**
 * 策略模式
 *        定义一个接口  多个实现类 调用根据需求传入不通的class。
 *        类似MVC3层架构 或 JDBC 调用 Oracle MySQL 都应该属于策略模式。
 * @author Administrator
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
