package gofmodel.Composite;

import java.util.List;

public abstract class MyElement {
	
	public abstract void eat();
	
	public abstract void add(MyElement m);
	
	public abstract void remove(MyElement m);
	
	public abstract List<MyElement> getChild();
	
	
}
