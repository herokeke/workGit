package gofmodel.TemplateMethod;

import org.junit.Test;

/**
 * 模板方法模式
 *    抽象 负责逻辑调用顺序
 *    子类 负责逻辑实现
 * @author Administrator
 *
 */
public class TemplateMethodTest {

	@Test
	public void testTemplateMethod(){
		
		ExtendFunction ef = new TaskMagaer(); //类似TaskMagaer多个实现 这里只举这一个例子。
		
		ef.process();
		
		
	}
}
