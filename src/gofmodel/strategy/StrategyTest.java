package gofmodel.strategy;

import org.junit.Test;

/**
 * ����ģʽ
 *        ����һ���ӿ�  ���ʵ���� ���ø��������벻ͨ��class��
 *        ����MVC3��ܹ� �� JDBC ���� Oracle MySQL ��Ӧ�����ڲ���ģʽ��
 * @author Administrator
 * 
 * ���壺һϵ�е��㷨��������һ������װ����������ʹ���ǿ����໥�滻����ģʽʹ���㷨�ı仯�ɶ�����ʹ�����Ŀͻ���
 * ˵����ʵ��ĳ���ܴ��ڶ��ַ�ʽ���ڲ��޸�����ϵͳ�Ļ����Ͽ������ѡ������ʵ�ַ�ʽ��Ҳ����ʹ���µ�ʵ�ַ�ʽ��
 * Ƶ�ʣ�4
 *
 */
public class StrategyTest {
	
	@Test
	public void testStrategy(){
		Context m = new Context(new MysqlClient());
		m.connectDBase();
		
		Context o = new Context(new OracleClient());
		o.connectDBase();
		
	}
	

}
