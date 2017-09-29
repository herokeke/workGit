package gofmodel.Iterator;

import java.util.ArrayList;
import java.util.List;

public class MyContainer extends Container {
	
	private List<Object> list;
	
	public MyContainer(){
		list = new ArrayList<Object>();
	}
	

	@Override
	public Iterator getIterator() {
		
		return new MyIterator(list);
	}

	@Override
	public void put(Object obj) {
		list.add(obj);
	}

}
