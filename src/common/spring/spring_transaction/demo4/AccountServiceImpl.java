package common.spring.spring_transaction.demo4;


public class AccountServiceImpl implements AccountService {

	
	//注入转账的Dao
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	@Override
	public void transfer(final String out, final String in, final Double money) {
		accountDao.outMoney(out, money);
		int i = 1 / 0;  
		accountDao.inMoney(in, money);
				
			
	
	}
	
	


}
