package gofmodel.proxy;

import java.lang.reflect.*;
/**
 * 定义：为其他对象提供一个代理以控制对这个对象的访问
 * 说明：当不能直接访问一个对象时，通过一个代理对象间接访问它。
 * 频率：4
 * @author Administrator
 *
 */
//动态代理
public class SecurityHandler implements InvocationHandler {

	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject){
		this.targetObject = targetObject;
		/*
		     newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		     ClassLoader loader：类加载器
             Class<?>[] interfaces：得到全部的接口
             InvocationHandler h：得到InvocationHandler接口的子类实例
		 */
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		checkSession();
		Object obj = method.invoke(targetObject, args);
		return obj;
	}

	public void checkSession(){
		System.out.println("handler--chek");
	}
}
