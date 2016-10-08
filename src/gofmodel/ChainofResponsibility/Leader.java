package gofmodel.ChainofResponsibility;

/**
 * 领导（抽象）
 * @author Administrator
 *
 */
public abstract class Leader {

	protected Leader leader;
	
	public  Leader setleader(Leader leader){
	    	this.leader = leader;
		 return this.leader;
	}
	
	public abstract Leader  handleRequest();
	
}
