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
