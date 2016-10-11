package gofmodel.Memento;

import org.junit.Test;

/**
 * 备忘录模式
 *       类似与Clone 的一种设计模式。
 * @author Administrator
 *
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
