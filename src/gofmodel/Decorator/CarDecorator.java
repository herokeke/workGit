package gofmodel.Decorator;

/**
 * 汽车装饰抽象类 
 *            装饰模式的核心
 * @author Administrator
 *
 */
public abstract class CarDecorator implements Car {

	private Car car;
	
	public CarDecorator(Car car){
		this.car = car;
	}
	
//	public  void  move(){
//		car.move();
//	}
	public abstract void  move();

	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	
}
