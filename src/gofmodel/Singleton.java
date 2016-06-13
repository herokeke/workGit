package gofmodel;

/**
 * ����ģʽ 
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
 * ����ʽ����
 * @author Administrator
 *
 */
class SingletonObjectLh{
	private static SingletonObjectLh singletonObjectLh = new SingletonObjectLh("�����������");
	private SingletonObjectLh(String str){
		System.out.println(str);
	}
	
	public static SingletonObjectLh getSingletonObjectLh(){
		return singletonObjectLh;
	}
	public void fun(){
		System.out.println("ִ�з���");
	}
}

/**
 * ��������
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
			
			singletonObjectEh = new SingletonObjectEh("�����������");
		}
		return singletonObjectEh;
	}
	
	public void fun(){
		System.out.println("ִ�з���");
	}
}

