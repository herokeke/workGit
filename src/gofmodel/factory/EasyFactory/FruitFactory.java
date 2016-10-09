package gofmodel.factory.EasyFactory;

public class FruitFactory {

	/*
	 *  方式一
	 *     newInstance: 弱类型。低效率。只能调用无参构造。
     *     new: 强类型。相对高效。能调用任何public构造。
	 */
	@SuppressWarnings("unchecked")
	public static Fruit getFruit(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class fruit = Class.forName(className); //A加载类
		return (Fruit) fruit.newInstance();   //实例化类
	}
	
	/*
	 * 方式二
	 */
	public static Fruit getFruitObj(String type) throws InstantiationException, IllegalAccessException{
		if(type.equalsIgnoreCase("apple")){
			return Apple.class.newInstance();
		}else if(type.equalsIgnoreCase("banana")){
			return Banana.class.newInstance();
		}else{
			return null;
		}
	}
}
