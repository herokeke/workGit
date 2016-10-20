package gofmodel.Facade;

import org.junit.Test;

/**
 * 外观模式
 *    有类似功能的类群，比如类库，子系（比如各种股票）统等等，提供一个一致的简单的界面（比如基金）。
 *    
 *    例子：在基金未出现之前  用户到市场买 各种股票、期货、外汇、国债。 
 *           基金出现之后，基金对市场的股票、期货、外汇、国债进行了组合。
 *           用户只要买基金就能买到各种组合。 
 *     
 *    不含任何抽象，都是实体类之间的调用。
 *    
 *    定义：为子系统中的一组接口提供一个一致的界面，定义一个高层接口，这个接口使得这一子系统更加容易使用。
 *    使用说明：为复杂的子系统提供一个统一的入口，简化客户端对多个子系统的访问。
 *    使用频率：5
 * @author Administrator
 *
 */
public class FacadeTest {
     
	@Test
	public void testFacade(){
		Fund f = new Fund();
		//稳健性投资
		f.strong();
		//风险性投资
		f.highrisk();
	}
}
