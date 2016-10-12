package gofmodel.Builder;

/**
 * 商品房  50年产权
 * @author Administrator
 *
 */
public class CommodityHourse implements HourseBuilder {
	
	 private Hourse hourse;
	 
	 public CommodityHourse(){
		 hourse = new Hourse();
	 }
	
	@Override
	public void body() {
		hourse.setBody("满墙壁纸");
		
	}

	@Override
	public void zhuangxiu() {
		hourse.setZhuangxiu("精装修");
		
	}

	@Override
	public void peitao() {
		hourse.setPeitao("健身器材");
		
	}

	
	public Hourse getHourse(){
		return hourse;
	}
	
}
