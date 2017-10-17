package gofmodel.proxy;

import java.lang.reflect.*;
/**
 * ���壺Ϊ���������ṩһ�������Կ��ƶ��������ķ���
 * ˵����������ֱ�ӷ���һ������ʱ��ͨ��һ����������ӷ�������
 * Ƶ�ʣ�4
 * @author Administrator
 *
 */
//��̬����
public class SecurityHandler implements InvocationHandler {

	private Object targetObject;
	
	public Object createProxyInstance(Object targetObject){
		this.targetObject = targetObject;
		/*
		     newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		     ClassLoader loader���������
             Class<?>[] interfaces���õ�ȫ���Ľӿ�
             InvocationHandler h���õ�InvocationHandler�ӿڵ�����ʵ��
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
