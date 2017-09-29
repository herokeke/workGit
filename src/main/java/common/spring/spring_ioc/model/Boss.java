package common.spring.spring_ioc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class Boss {
	
	private List propList ;
	private Set propSet = new HashSet();
	private Map propMap = new HashMap();
	private Properties properties;
	
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public List getPropList() {
		return propList;
	}
	public void setPropList(List propList) {
		this.propList = propList;
	}
	public Set getPropSet() {
		return propSet;
	}
	public void setPropSet(Set propSet) {
		this.propSet = propSet;
	}
	public Map getPropMap() {
		return propMap;
	}
	public void setPropMap(Map propMap) {
		this.propMap = propMap;
	}
	
	
	
}
