package gofmodel.factory.AbstractFactory;
import org.junit.Test;
/**
 * 抽象工厂
 *      产品结构：如汽车制造厂中 车中的各个部件。（设计： 不会继续改动的类型）
 *      产品簇：  如汽车的颜色， 五颜六色，以后还可以组合更多种的颜色。（设计：改动频繁，后续随意添加或删除）
 *      
 *      
 *      设计思路：                 接口                                      接口工厂 ｛
 *                                                                        public 接口 get抽象类A();
 *                                                                        public 接口 get抽象类B();
 *                                                                         ｝ 
 *                  抽象类A                  抽象类B             实现类红色簇工厂       实现类黄色簇工厂
 *          实现类A红色簇 实现类A黄色簇   实现类B红色簇 实现类B黄色簇
 * @author Administrator
 *
 */
public class AbstractFactoryTest {
	
	@Test
	public void testAbstractFactory(){
		FruitFactory cyanff = 	new CyanFactory();
		Fruit capple = cyanff.getApple();
		capple.eat();
		Fruit cbanana = cyanff.getBanana();
		cbanana.eat();
		
		FruitFactory yellosff = new YellowFactory();
		Fruit yapple = yellosff.getApple();
		yapple.eat();
		Fruit ybanana = yellosff.getBanana();
		ybanana.eat();
	}

}
