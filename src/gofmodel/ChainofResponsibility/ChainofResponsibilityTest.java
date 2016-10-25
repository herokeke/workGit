package gofmodel.ChainofResponsibility;

import org.junit.Test;

/**
 *  责任链模式也叫职责链模式或者职责连锁模式
 *  
 *  SERVLET容器的过滤器（Filter）框架实现
 *  
 *  定义：为解除请求的发送者和接收者之间的耦合，而使多个对象都有机会处理这个请求，将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它。
 *  说明：将能够处理同一类请求的对象连成一条链，所有提交的请求沿着链传递，链上的对象逐个判断是否有能力处理该请求，如果能责处理，如果不能则传递给链上的下一对象。
 *  频率：2
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

