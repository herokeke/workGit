package gofmodel.ChainofResponsibility;

/**
 * 主任
 * @author Administrator
 *
 */
public class Director extends Leader {

	/*
	 * 递归调用
	 * (non-Javadoc)
	 * @see gofmodel.ChainofResponsibility.Leader#handleRequest(gofmodel.ChainofResponsibility.Leader)
	 */
	@Override
	public Leader handleRequest() {
		System.out.println("主任");
		if(leader != null){
			this.leader.handleRequest();
		}
		return this.leader;
	}

}
