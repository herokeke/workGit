package gofmodel.Bridge.bridge;

/**
 * 长方形
 * @author Administrator
 *
 */
public  class Rectangle extends Drawing {

	public Rectangle(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		this.getColor().draw(); //调用行为方法， 可组合不通的行为。
		System.out.println("长方形");
		
	}

	
}
