package gofmodel.Observer;

import org.junit.Test;

/**
 * 观察者模式
 *      java中类事件处理机制，几乎所有的GUI事件处理模型中都运用了观察者模式
 *   java.util.Observable 被观察者(目标) 继承的实体
 *   java.util.Observer   观察者 需要实现的接口
 * @author Administrator
 *
 *定义：对象间的一种一对多的依赖关系，以便当一个对象的状态发生改变时，所有依赖于他的对象都得到通知并自动刷新。
 *说明：一个对象的行为将影响到一个或多个其他对象的行为。
 *频率：5
 */
public class ObserverTest {

	@Test
	public void testObserver(){
		Person p = new Person();
		p.addObserver(new MyObserver()); //注册观察者
		p.countObservers();
		//执行一个方法都会触发 update
		p.setAge(10);
		p.setName("大娃");
		p.setSex("男人");
		
	}
}
