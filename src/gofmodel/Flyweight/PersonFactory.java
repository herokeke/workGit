package gofmodel.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class PersonFactory {

	private  Map<String,Person> poolperson;
	
	public PersonFactory(){
		poolperson = new HashMap<String,Person>();
	}
	
	public  Person getPerson(String state){
		Person person  = poolperson.get(state);
		if(person==null){
			person = new Blacks();
			poolperson.put(state, person);
		}
		return person;
	}
}
