package common.spring.spring_ioc.model;

public class CarFactory {
	
     public static Car createCar(){
    	 Car car = new Car();
    	 car.setBrand("劳斯莱斯");
		return car;
     }
	
}
