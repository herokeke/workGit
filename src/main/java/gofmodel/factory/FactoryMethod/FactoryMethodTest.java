package gofmodel.factory.FactoryMethod;

import org.junit.Test;

/**
 * 工厂方法
 *     工厂方法模式同样属于类的创建型模式又被称为多态工厂模式 
 *     很好的符合了“开放－封闭”原则。
 *     工厂方法模式退化后可以演变成简单工厂模式。 
 *     
 *     设计思路：     接口            接口工厂 
 *             实现类A 实现类B    实现类A工厂 实现类B工厂
 *     
 * @author Administrator
 *
 */
public class FactoryMethodTest {

	@Test
	public void TestFactoryMethod(){
		FruitFactory fapple = new AppleFactory();
		Fruit apple = fapple.getFruit();
		apple.eat();
		FruitFactory fbanana = new BananaFactory();
		Fruit banana = fbanana.getFruit();
		banana.eat();
	}
}
