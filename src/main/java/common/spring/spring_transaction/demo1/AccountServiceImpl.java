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
		//int i = 1 / 0; //发生异常后 数据的一致性受到破坏。
		accountDao.inMoney(in, money);
		

	}

}
