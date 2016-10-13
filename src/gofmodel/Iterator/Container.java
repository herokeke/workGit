package gofmodel.Iterator;


/**
 * 抽象容器
 * @author Administrator
 *
 */
public abstract class Container {
	
	public abstract Iterator getIterator();
	
    public abstract void put(Object obj);

}
