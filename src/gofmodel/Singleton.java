package gofmodel;

/**
 * 单例模式 
 * @author Administrator
 *
 */
public class Singleton {
	public static void main(String[] args){
		SingletonObjectLh slol = SingletonObjectLh.getSingletonObjectLh();
		slol.fun();
		slol.fun();
		
		SingletonObjectEh sloe = SingletonObjectEh.getSingletonObjectEh();
		sloe.fun();
		sloe.fun();
	}
}

/**
 * 饿汉式加载
 * @author Administrator
 *
 */
class SingletonObjectLh{
	private static SingletonObjectLh singletonObjectLh = new SingletonObjectLh("懒汉构造对象");
	private SingletonObjectLh(String str){
		System.out.println(str);
	}
	
	public static SingletonObjectLh getSingletonObjectLh(){
		return singletonObjectLh;
	}
	public void fun(){
		System.out.println("执行方法");
	}
}

/**
 * 懒汉加载
 * @author Administrator
 *
 */
class SingletonObjectEh{
	private static SingletonObjectEh singletonObjectEh;
	private SingletonObjectEh(String str){
		System.out.println(str);
		System.out.println(str);
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
	}
	
	public static SingletonObjectEh getSingletonObjectEh(){
		if(singletonObjectEh == null ){
			
			singletonObjectEh = new SingletonObjectEh("饿汉构造对象");
		}
		return singletonObjectEh;
	}
	
	public void fun(){
		System.out.println("执行方法");
	}
}

