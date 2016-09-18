package common.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.hibernate.model.UserInfo;

public class HibernateTest {
	
	private  SessionFactory sessionFactory ; 
	private  Session session ; 
	private  Transaction transaction ;
	
	@Before
	public void init() throws Exception {
		Configuration cofig = new Configuration().configure("common\\hibernate\\hibernate.cfg.xml"); //创建配置对象
		ServiceRegistry   serviceRegistry = new ServiceRegistryBuilder().applySettings(cofig.getProperties()).buildServiceRegistry(); //创建服务注册对象
		sessionFactory  = cofig.buildSessionFactory(serviceRegistry); //创建会话工厂对象
		session = sessionFactory.openSession(); //打开会话
		transaction = session.beginTransaction(); // 打开事物
	}

	@After
	public  void tearDown() throws Exception {
		this.transaction.commit();
		this.session.close();
		this.sessionFactory.close();
	}
	
	/*  Session
	 * 采用getCurrentSession()创建的Session会绑定到当前的线程中去、而采用OpenSession()则不会。
        采用getCurrentSession()创建的Session在commit或rollback后会自动关闭，采用OpenSession()必须手动关闭。
        采用getCurrentSession()需要在Hibernate.cfg.xml配置文件中加入如下配置：
       <property name="current_session_context_class">thread</property>
	 */
	@Test
	public void testHibernate00(){
		Session	session1 =   sessionFactory.openSession();
		Session	session2 =   sessionFactory.openSession();
	    System.out.println("openSession==>"+(session1==session2));
		Session	session3 = 	sessionFactory.getCurrentSession();
		Session session4 = 	sessionFactory.getCurrentSession();
		System.out.println("sessionFactory==>"+(session3==session4));
		
	}
	
	/* get load doWork flush 
	 * 
	 *  
	 *  
	 */
	
	
	/*缓存
	 * 
	 */
	@Test
	public void testHibernate01(){
		
		UserInfo s1 =(UserInfo) session.get(UserInfo.class,"8bb024d596a74855b1d47d40b2a86d1a");
		System.out.println(s1.getFullname());
		
		UserInfo s2 =(UserInfo) session.get(UserInfo.class,"8bb024d596a74855b1d47d40b2a86d1a");
		System.out.println(s2.getFullname());
		
	}
	
	
	
	@BeforeClass
	public static void before() throws Exception {
	}
	@AfterClass
	public static void after() throws Exception {
	}
}
