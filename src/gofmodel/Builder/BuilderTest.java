package gofmodel.Builder;

import org.junit.Test;

/**
 * 建造者模式  主要是围绕对象的创建过程，大量的创建不同特性的对象，用该模式较好。或者用于权限的不同控制。
 * 
 */
public class BuilderTest {
	
	@Test
	public void testBuilder(){
		HourseBuilder bh = new BungalowHourse(); //平房
		HourseBuilder ch = new CommodityHourse(); //商品楼
		HourseBuilder rh = new ResidenceHourse(); //住宅楼
		
		HouseDirector houseDirector = new HouseDirector();
		houseDirector.createBungalow(bh);
		
		
		Hourse hourse = bh.getHourse();
		System.out.println(hourse.getBody());
		System.out.println(hourse.getPeitao());
		System.out.println(hourse.getZhuangxiu());
		
		hourse = ch.getHourse();
		houseDirector.createHighRise(ch);
		System.out.println(hourse.getBody());
		System.out.println(hourse.getPeitao());
		System.out.println(hourse.getZhuangxiu());
		
		hourse = rh.getHourse();
		houseDirector.createHighRise(rh);
		System.out.println(hourse.getBody());
		System.out.println(hourse.getPeitao());
		System.out.println(hourse.getZhuangxiu());
		
	}

}
