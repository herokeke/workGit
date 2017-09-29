package common.spring.spring_transaction.demo1;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate  jdbcTemplate;
	
	@Override
	public void outMoney(String out, Double money) {
		String sql="update account set money = money - ? where name = ?";
		//this.getJdbcTemplate().update(sql,money,out);
		jdbcTemplate.update(sql,money,out);

	}
	
	@Override
	public void inMoney(String in, Double money) {
		String sql="update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql,money,in);
		//jdbcTemplate.update(sql,money,in);

	}


}
