package gofmodel.Bridge.bridge;

/**
 * 圆形
 * @author Administrator
 *
 */
public  class Circular extends Drawing {

	public Circular(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		this.getColor().draw(); //调用行为方法， 可组合不通的行为。
		System.out.println("圆形");
		
	}

	

}
