package gofmodel.TemplateMethod;

import org.junit.Test;

/**
 * 模板方法模式
 *    抽象 负责逻辑调用顺序
 *    子类 负责逻辑实现
 * @author Administrator
 * 定义：一个操作中的算法骨架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 说明：在父类中提供一个方法定义一个操作序列，而将具体操作的实现放在子类中。
 * 频率：3
 *
 */
public class TemplateMethodTest {

	@Test
	public void testTemplateMethod(){
		
		ExtendFunction ef = new TaskMagaer(); //类似TaskMagaer多个实现 这里只举这一个例子。
		
		ef.process();
		
		
	}
}
