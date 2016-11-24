package common.spring.spring_transaction.demo1;

public class AccountServiceImpl implements AccountService {

	//注入转账的Dao
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
		accountDao.inMoney(in, money);
		

	}

}
