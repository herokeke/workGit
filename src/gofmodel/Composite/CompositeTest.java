package gofmodel.Composite;

import java.util.List;

import org.junit.Test;

/**
 * 组合模式
 *     1. 有容器特征的对象，普通的对象称为叶子。
 *     
 *     例子： 在一个大水果盘中有一些水果和一些小的水果盘，
 *           在小的水果盘中有一些水果和一些更小的水果盘。
 *           .......无限制
 *     提示： 水果相当于叶子， 果盘相当于容器。
 * @author Administrator
 *
 */
public class CompositeTest {
	
	@Test
	public void testComposite(){
		MyElement plate  =  new Plate("青花瓷大盘子");
		MyElement platez  =  new Plate("青花瓷中盘子");
		MyElement platex  =  new Plate("青花瓷小盘子");
		MyElement apple  =  new Apple("红富士");
		MyElement banana =  new Banana("海南蕉");
		MyElement pear  =    new Pear("南果梨");
		plate.add(apple);
		plate.add(banana);
		plate.add(pear);
		platez.add(apple);
		platex.add(pear);
		plate.add(platez);
		plate.add(platex);
		displayTree(plate,0);
		
	}
	
	/*
	 * 树结构展示，及深度探测
	 */
	public void displayTree(MyElement plate,int deep){
		for(int i=0;i < deep;i++){
			System.out.print("--");
		}
		plate.eat();
	    List<MyElement> child = plate.getChild();
	    for(MyElement element : child){
	    	 if(element instanceof Plate){ //容器
	    		 displayTree(element,deep+1);
	    	 }else{ 
	    			for(int i=0;i <= deep;i++){
	    				System.out.print("--");
	    			}
	    		 element.eat();
	    	 }
	    	
	    }
	}

}
