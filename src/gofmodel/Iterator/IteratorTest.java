package gofmodel.Iterator;

import org.junit.Test;

/**
 * 迭代模式
 *   Iterator 的实现思路
 *            内部类。
 *            提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
 *            单一职责原则，分离了集合对象的遍历行为，抽象出一个迭代器类来负责；
 *            
 *            
 *            定义：提供一种方法顺序访问一个聚合对象中各个元素，而又不需要暴露该对象的内部表示。
 *            说明：通过一个专门的对象来对聚合对象进行遍历，而不需要直接操作聚合对象。
 *            频率：5
 * @author Administrator
 *
 */
public class IteratorTest {

	@Test
	public void testIterator(){
		Container container = new MyContainer();
		container.put("11");
		container.put("22");
		container.put("33");
		container.put("44");
		container.put("55");
		
		Iterator it = container.getIterator();
		
		System.out.println(it.first());
		System.out.println(it.previous());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.first());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.previous());
		System.out.println(it.previous());
		System.out.println(it.previous());
		System.out.println(it.previous());
		System.out.println(it.previous());
		System.out.println("------------------迭代器遍历示例------------------");
		System.out.println(it.first());
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
}
