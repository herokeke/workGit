package gofmodel.Decorator;

/**
 * 行车记录仪
 * @author Administrator
 *
 */
public class SatnavDecorator extends CarDecorator {

	public SatnavDecorator(Car car) {
		super(car);
	}
	
	public void Satnav(){
		System.out.println("安装有行车记录仪");
	}

	@Override
	public void move() {
		this.getCar().move();
		this.Satnav();
		
	}

	
}
