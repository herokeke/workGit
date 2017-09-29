package gofmodel.Builder;

/**
 * 普通住宅 70年产权
 * @author Administrator
 *
 */
public class ResidenceHourse implements HourseBuilder {
	 private Hourse hourse;
	
	public ResidenceHourse(){
		hourse = new Hourse();
	}

	@Override
	public void body() {
		hourse.setBody("四白落地实体墙");

	}

	@Override
	public void zhuangxiu() {
		hourse.setZhuangxiu("简装");

	}

	@Override
	public void peitao() {
		hourse.setPeitao("太阳能热水器");

	}
	
	public Hourse getHourse(){
		return hourse;
	}

}
