package gofmodel.Adapter;

import org.junit.Test;

/**
 * 适配器模式
 *         顾名思义：相当于电源的稳压器，使原本不兼容的事物（对象）能够协同工作，而无需修改现有事物（对象）的内部结构。
 *         
 *         实现描述： 方法调用方法。
 * @author Administrator
 *
 */
public class AdapterTest {

	@Test
	public void testAdapter(){
		// 继承模式
		
		Adapter a = new Adapter();
		a.u18V();
		
		//为让模式
		AdapterLoader al = new AdapterLoader(new Current());
		al.u18V();
		
	}
}
