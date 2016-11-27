package common.spring.spring_transaction.demo5;

import org.springframework.transaction.annotation.Transactional;
/**
 * 通过注解管理事务
 * propagation 事务的传播行为
 * isolation 事务的隔离级别
 * readOnly  只读
 * rollbackFor 发生哪些异常回滚
 * noRollbackFor 发生那些异常不回滚
 * @author User
 */
@Transactional
public class AccountServiceImpl implements AccountService {

	
	//注入转账的Dao
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	@Override
	public void transfer(final String out, final String in, final Double money) {
		accountDao.outMoney(out, money);
		 //int i = 1 / 0; 
		accountDao.inMoney(in, money);
	}
	
	


}
