package gofmodel.Builder;

/**
 * 策略者
 * @author Administrator
 *
 */
public class HouseDirector {
	
	/*
	 *  建造平房顺序
	 */
	public void createBungalow(HourseBuilder hourseBuilder){
		hourseBuilder.body();
		hourseBuilder.zhuangxiu();
	}
	
	/*
	 * 建造楼房顺序
	 */
	public void createHighRise(HourseBuilder hourseBuilder){
		hourseBuilder.body();
		hourseBuilder.zhuangxiu();
		hourseBuilder.peitao();
	}

}
