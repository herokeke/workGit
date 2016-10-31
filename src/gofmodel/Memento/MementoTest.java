package gofmodel.Memento;

import org.junit.Test;

/**
 * 备忘录模式
 *       类似与Clone 的一种设计模式。
 *       如：在“取消“ 或者 ”驳回“。”回退“等操作时候，使用。
 * @author Administrator
 *
 *定义：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样以后就可以将该对象恢复到保存的状态。
 *说明：提供一个后悔的机制，使得对象可以恢复到某一个历史状态。
 *频率：2
 */
public class MementoTest {
	
	@Test
	public void  testMemento(){
		Person p = new Person("大娃",10,"男");
		
		Memento memento = p.createMemento();
		
		p.setSex("女");
		p.display();
		
		p.recoverMemento(memento);
		p.display();
		
		
	}

}
