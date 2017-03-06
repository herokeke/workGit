package common.spring.spring_ioc.model;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
	
	private String carInfo;

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		System.out.println(this.getCarInfo());
		car.setBrand("徐福林");
		car.setSpeed(200);
		return car;
	}

	@Override
	public Class<Car> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
	
   
	
}
