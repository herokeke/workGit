package common.spring.spring_transaction.demo4;

public interface AccountDao {
	
	public void outMoney(String out,Double money);
	
	public void inMoney(String in,Double money);

}
