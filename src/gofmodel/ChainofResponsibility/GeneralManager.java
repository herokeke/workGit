package gofmodel.ChainofResponsibility;

/**
 * 经理
 * @author Administrator
 *
 */
public class GeneralManager extends Leader {

	/*
	 * 递归调用
	 * (non-Javadoc)
	 * @see gofmodel.ChainofResponsibility.Leader#handleRequest(gofmodel.ChainofResponsibility.Leader)
	 */
	@Override
	public Leader handleRequest() {
		System.out.println("经理");
		if(leader != null){
			this.leader.handleRequest();
		}
		return this.leader;
	}

}
