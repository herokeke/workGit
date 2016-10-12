package gofmodel.Decorator;

import org.junit.Test;

/**
 * 装饰模式，又叫包装模式
 *     类似于房子装修，在不改变房子本质的同时，让房子变得更加漂亮。对象（房子）进行扩展。
 *     
 *    继承关系的一个替换方案。不需要建立更多子类的情况下，对功能进行扩展。 
 *     父类 通过子类进行功能的扩展，需要建立多个子类。
 *         引进装饰模式后创建装饰模式接口，通过不通的装饰实现，只需要一个子类，去进行功能的扩展。
 *         多个装饰实现 可以 完成一种叠加的效果（功能和功能的组合）。
 *         
 *     IO流 中 运用的装饰模式 (BufferReader) 
 * @author Administrator
 *
 */
public class DecoratorTest {
	
	@Test
	public void testDecorator(){
		Car car = new NormalCar();
		//car.move();
		
		//装饰器，是原来的对象变得更丰富
		Car decorator = new SatnavDecorator(car);
		    decorator = new ViewCameraDecorator(decorator);
		    decorator.move();
		
	}

}
