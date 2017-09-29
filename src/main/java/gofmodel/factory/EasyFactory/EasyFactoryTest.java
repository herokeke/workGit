package gofmodel.factory.EasyFactory;

import org.junit.Test;

/**
 * 简单工厂
 *       类似工具类设计，通过工厂方法创建出对象。
 * @author Administrator
 *
 */
public class EasyFactoryTest {

	@Test
	public void testEasyFactory(){
		Fruit fruit = null;
		try {
			fruit  = FruitFactory.getFruit("gofmodel.factory.EasyFactory.Banana");
			fruit.eat();
			fruit  = FruitFactory.getFruit("gofmodel.factory.EasyFactory.Apple");
			fruit.eat();
			fruit  = FruitFactory.getFruitObj("Banana");
			fruit.eat();
			fruit  = FruitFactory.getFruitObj("Apple");
			fruit.eat();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
