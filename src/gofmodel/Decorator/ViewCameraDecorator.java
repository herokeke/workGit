package gofmodel.Decorator;

public class ViewCameraDecorator extends CarDecorator {

	public ViewCameraDecorator(Car car) {
		super(car);
	}
	
	public void RearViewCamera(){
		System.out.println("装有行车记录仪");
	}

	@Override
	public void move() {
		this.getCar().move();
		this.RearViewCamera();
		
	}

}
