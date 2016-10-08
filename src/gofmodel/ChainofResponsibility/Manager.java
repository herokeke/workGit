package gofmodel.ChainofResponsibility;

/**
 * 总经理
 * @author Administrator
 *
 */
public class Manager extends Leader {

	/*
	 * 递归调用
	 * (non-Javadoc)
	 * @see gofmodel.ChainofResponsibility.Leader#handleRequest(gofmodel.ChainofResponsibility.Leader)
	 */
	@Override
	public Leader handleRequest() {
		System.out.println("总经理");
		if(leader != null){
			this.leader.handleRequest();
		}
		return this.leader;
	}

}
