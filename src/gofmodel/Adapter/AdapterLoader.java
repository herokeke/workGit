package gofmodel.Adapter;

/**
 * 委让实现
 * @author Administrator
 *
 */
public class AdapterLoader {

	private Current current;
	
	public AdapterLoader(Current current){
		this.current = current;
	}
	
	public void u18V(){
		current.u220V();
	}
}
