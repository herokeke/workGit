package gofmodel.strategy;

public class MysqlClient implements Datebase {

	@Override
	public void connect() {
	System.out.println("MySql连接数据库");

	}

}
