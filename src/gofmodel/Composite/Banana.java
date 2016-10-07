package gofmodel.Composite;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class Banana extends MyElement {

	private String name;
	
	public Banana(String name){
		this.name = name;
	}
	
	public void eat() {
		 System.out.println("吃"+this.name);

	}

	@Override
	public void add(MyElement m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MyElement> getChild() {
		return null;
		
	}

	@Override
	public void remove(MyElement m) {
		// TODO Auto-generated method stub
		
	}

}
