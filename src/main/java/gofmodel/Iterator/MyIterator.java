package gofmodel.Iterator;

import java.util.List;

public class MyIterator implements Iterator {
	
	private List<Object> list;
	
	private int count = 0;

	public MyIterator(List<Object> list){
		this.list = list;
	}
	
	@Override
	public Object first() {
		if(list.size()>0){
			count = 0;
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		if(list.size()>(count+1) ){
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		if(list.size()>(count+1) ){
			return list.get(++count);
		}
		return null;
	}

	@Override
	public Object previous() {
		if((count-1)>=0 ){
			return list.get(--count);
		}
		return null;
	}
	

}
