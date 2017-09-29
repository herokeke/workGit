package gofmodel.Builder;

/**
 * 平房
 * @author Administrator
 *
 */
public class BungalowHourse implements HourseBuilder {
	
	 private Hourse hourse;
	 
	 public BungalowHourse(){
		 hourse = new Hourse();
	 }
	
	@Override
	public void body() {
		hourse.setBody("四周砖墙");

	}

	@Override
	public void peitao() {
          //空实现
	}

	@Override
	public void zhuangxiu() {
		hourse.setZhuangxiu("毛坯");

	}
	
	@Override
	public Hourse getHourse() {
		return hourse;
	}

}
