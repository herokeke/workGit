package gofmodel.Bridge;


import gofmodel.Bridge.bridge.Black;
import gofmodel.Bridge.bridge.Circular;
import gofmodel.Bridge.bridge.Color;
import gofmodel.Bridge.bridge.Rectangle;
import gofmodel.Bridge.bridge.White;
import gofmodel.Bridge.normal.BlackCircular;
import gofmodel.Bridge.normal.BlackRectangle;
import gofmodel.Bridge.normal.Drawing;
import gofmodel.Bridge.normal.WhiteCircular;
import gofmodel.Bridge.normal.WhiteRectangle;

import org.junit.Test;

/**
 * 桥接模式
 *      它的主要特点是把抽象（abstraction）与行为实现（implementation）分离开来。
 *   例子：
 *                                      图形
 *                      长方形             |          圆形                  // 抽象类 对象
 *         白色长方形  黑色长方形  黄色长方形   | 白色圆形  黑色圆形  黄色圆形      //颜色为行为
 *         
 *   采用桥连模式后：      
 *               长方形   圆形   白色   黑色    黄色                 // 类 对象
 *    白色长方形  黑色长方形  黄色长方形   白色圆形  黑色圆形  黄色圆形    //颜色为行为
 *         
 *               
 * @author Administrator
 *
 */   
public class BridgeTest {
	
	/*
	 * 采用桥连模式实现
	 * 
	 *  很好的组合，更好的体现在 N*N 的 模式中。减少了实现类的开发量。
	 */
	@Test
	public void testBridge(){
		System.out.println("========采用桥连模式实现============");
		Color black= new Black();
		Color white= new White();
		
		gofmodel.Bridge.bridge.Drawing  whiteCircular = (gofmodel.Bridge.bridge.Drawing)new Circular(white);
		whiteCircular.draw();
		
		gofmodel.Bridge.bridge.Drawing  whiteRectangle = (gofmodel.Bridge.bridge.Drawing)new Rectangle(white);
		whiteRectangle.draw();
		

		gofmodel.Bridge.bridge.Drawing  blackCircular = (gofmodel.Bridge.bridge.Drawing)new Circular(black);
		blackCircular.draw();
		
		gofmodel.Bridge.bridge.Drawing  blackRectangle = (gofmodel.Bridge.bridge.Drawing)new Rectangle(black);
		blackRectangle.draw();
		
		
	}
	
	/*
	 * 普通实现
	 */
	@Test
	public void testNormal(){
		System.out.println("=======普通实现=======");
		Drawing wc = new WhiteCircular();
		Drawing wr = new WhiteRectangle();
		Drawing bc = new BlackCircular();
		Drawing br = new BlackRectangle();
		wc.draw();
		wr.draw();
		bc.draw();
		br.draw();
		
		
	}
	

}
