package common.spring.spring_ioc.model;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class SuperBoss implements MethodReplacer {

	private Car car;
	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// car.setColor("黑色");
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
