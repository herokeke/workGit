package gofmodel.proxy;

import java.lang.reflect.*;

//动态代理
public class SecurityHandler implements InvocationHandler {

	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject){
		this.targetObject = targetObject;
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
