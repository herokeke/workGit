package gofmodel.strategy;

public class OracleClient implements Datebase {

	@Override
	public void connect() {
		System.out.println("Oracle连接数据库");
	}

}
