package gofmodel.Flyweight;

import org.junit.Test;

/**
 * 享元模式  对象池 通过Map	集合
 *          它通过与其他类似对象共享数据来减小内存占用。
 *          在JAVA语言中，String类型就是使用了享元模式。String对象是final类型，对象一旦创建就不可改变。在JAVA中字符串常量都是存在常量池中的，JAVA会确保一个字符串常量在常量池中只有一个拷贝。String a="abc"，其中"abc"就是一个字符串常量。
 * @author Administrator
 *
 *     定义：运用共享技术有效的支持大量细粒度的对象。
 *     说明：通过共享技术实现对象的重用，大量节约系统的内存，该模式关心系统的性能与资源利用情况。
 *     频率：1
 */
public class FlyweightTest {
	
	@Test
	public void testFlyweight(){
		PersonFactory pf = new PersonFactory();
		Person p1,p2,p3;
		final  String F ="非洲";
		final  String G ="刚果";
		p1 = pf.getPerson(F);
		p1.operation(F);
		p2 = pf.getPerson(G);
		p2.operation(G);
		p3 = pf.getPerson(G);
		p3.operation(G);
		System.out.println(p1==p2);
		System.out.println(p2==p3); // 实现了共享
		   
	}

}
