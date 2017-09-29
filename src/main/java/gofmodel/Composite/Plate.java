package gofmodel.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 盘子
 */
public class Plate extends MyElement {
	
	private String name;
	
	private List<MyElement> myElement;
	
	public Plate(String name){
		this.name = name;
		myElement = new ArrayList();
	}

	@Override
	public void eat() {
      System.out.println(this.name);
	}
	
	public void add(MyElement m){
		myElement.add(m);
	}
	
	public void remove(MyElement m){
		myElement.remove(m);
	}
	
	public List<MyElement> getChild(){
		
		return myElement;
		
	}

}
