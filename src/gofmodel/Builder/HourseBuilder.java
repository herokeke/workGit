package gofmodel.Builder;


/**
 * 建造房
 * @author Administrator
 *
 */
public interface HourseBuilder {

	//主体结构
	public void body();
	
	//精装
	public void zhuangxiu();
	
	//配套
	public void peitao();
	
	public Hourse getHourse();
}
