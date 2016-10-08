package gofmodel.ChainofResponsibility;

import org.junit.Test;

/**
 *  责任链模式也叫职责链模式或者职责连锁模式
 *  
 *  SERVLET容器的过滤器（Filter）框架实现
 *  
 * @author Administrator
 *
 */
public class ChainofResponsibilityTest {
	
	@Test
	public void testChainofResponsibility(){
		Leader director = new Director(); //主任
		Leader manager = new Manager(); //经理
		Leader generalManager = new GeneralManager(); // 总经理
		director.setleader(manager).setleader(generalManager);
		director.handleRequest();
		System.out.println("=======");
		manager.handleRequest();
		System.out.println("=======");
		generalManager.handleRequest();
	}
	
	//TODO  过滤器的实现  
	//TODO  拦截器 ？？

}

