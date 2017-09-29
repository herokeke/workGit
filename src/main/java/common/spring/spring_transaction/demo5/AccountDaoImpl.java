package common.spring.spring_transaction.demo5;


import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void outMoney(String out, Double money) {
		String sql="update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(sql,money,out);

	}
	
	@Override
	public void inMoney(String in, Double money) {
		try{
			int i = 1 / 0; 
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String sql="update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql,money,in);
	}


}
