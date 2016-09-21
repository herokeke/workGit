package common.hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.hibernate.model.Address;
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
		transaction = session.beginTransaction(); // 打开事物  session 封装在整个事物当中，在关闭seesion前要先提交事物，否则不生效。
	}

	@After
	public  void tearDown() throws Exception {
		this.transaction.commit();
		this.session.close();
		this.sessionFactory.close();
	}
	
	
	/*  Session ?
	 * 采用getCurrentSession()创建的Session会绑定到当前的线程中去、而采用OpenSession()则不会。
        采用getCurrentSession()创建的Session在commit或rollback后会自动关闭，采用OpenSession()必须手动关闭。
        采用getCurrentSession()需要在Hibernate.cfg.xml配置文件中加入如下配置：
       <property name="current_session_context_class">thread</property>
	 */
	@Test
	public void testHibernateSession(){
		Session	session1 =  sessionFactory.openSession();
		UserInfo user = new UserInfo("1","1","1","1","1","1","1");
		session1.doWork(new Work(){
			@Override
			public void execute(Connection connection) throws SQLException {
				connection.setAutoCommit(true); // 设置提交不开启事务 否则会报错必须要提前开启事务。
			}
		});
		session1.save(user);
		/**
		 * flush方法的主要作用就是清理缓存，强制数据库与Hibernate缓存同步，以保证数据的一致性。它的主要动作就是向数据库发送一系列的sql语句，并执行这些sql语句，但是不会向数据库提交。而commit方法则会首先调用flush方法，然后提交事务。这就是为什么我们仅仅调用flush的时候记录并未插入到数据库中的原因，因为只有提交了事务，对数据库所做的更新才会被保存下来。因为commit方法隐式的调用了flush，所以一般我们都不会显示的调用flush方法。
           这是hibernate的flush机制。在一些复杂的对象更新和保存的过程中就要考虑数据库操作顺序的改变以及延时flush是否对程序的结果有影响。如果确实存在着影响，那就可以在需要保持这种操作顺序的位置加入flush强制Hibernate将缓存中记录的操作flush入数据库，这样看起来也许不太美观，但很有效。
		 */
		session1.flush();
		session1.close();
		
		
		Session	session2 =   sessionFactory.openSession();
	    System.out.println("openSession==>"+(session1==session2));
	    
	    
		Session	session3 = 	sessionFactory.getCurrentSession();
		session3.beginTransaction();
		session3.doWork(new Work(){
			@Override
			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("session3=="+connection.hashCode());
			}
		});
		
		Session session4 = 	sessionFactory.getCurrentSession();
		
		//session4.beginTransaction(); //只能打开一次事物，不能重复打开，否则会抛出异常
		
		session4.doWork(new Work(){
			@Override
			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("session4=="+connection.hashCode());
			}
		});
		System.out.println("sessionFactory==>"+(session3==session4));
		
	}
	
	/**
	 * 在不考虑缓存的情况下，get方法会在调用之后立即向数据库发出sql语句，返回持久化对象 
	 * 对象不存在 返回 null
	 */
	@Test
	public void testUserInfoGet(){
		UserInfo s1 =(UserInfo) session.get(UserInfo.class,"1");
		
	}
	/**
	 * 调用之后返回一个代理对象。
	 * 该代理对象只保存了实体对象的ID，直到使用对象的非主键属性时才会发出SQ语句。
	 * 对象不存在 抛出 ObjectNotFoundException 异常。
	 */
	@Test
	public void testUserInfoLoad(){
		UserInfo s2 =(UserInfo) session.load(UserInfo.class,"1");
	//	 System.out.println(s2); //注释该方法 不会发送语句 。否则会发送语句 在控制台可看到效果
	}
	
	/**
	 *  更新数据 涉及到二级缓存的配置  
	 *   read-write  可以进行修改
	 *   "read-only" 会抛出 java.lang.UnsupportedOperationException: Can't write to a readonly object
	 *   read- only：无需修改， 那么就可以对其进行只读 缓存，注意，在此策略下，如果直接修改数据库，即使能够看到前台显示效果，但是将对象修改至cache中会报error，cache不会发生作用。
	 *               另：删 除记录会报错，因为不能在read-only模式的对象从cache中删除。
	 */
	@Test
	public void testUserInfoUpdate(){
		//session.clear();
		UserInfo s2 =(UserInfo) session.get(UserInfo.class,"1");
		System.out.println(s2);
		if(s2!=null){
			s2.setSex("男");
			session.update(s2);
		}
		
	}
	/**
	 *  删除数据 跟read-only无关
	 */
	@Test
	public void testUserInfoDelete(){
		UserInfo s2 =(UserInfo) session.get(UserInfo.class,"1");
		if(s2!=null){
		  session.delete(s2);
		}
	}
	
	
	/*一级缓存  session 级缓存
	 * 二级缓存 全局缓存 采用第三方实现
	 * 当Hibernate根据ID访问数据对象的时候，首先从Session一级缓存中查；查不到，如果配置了二级缓存，那么从二级缓存中查；查不到，再查询数据库，把结果按照ID放入到缓存。
	 * 
	 * read-write 二级缓存 失败 ？
	 * read-only 二级缓存  成功 ？
	 * 
	 * nonstrict-read-write 可以二级缓存 也可以update 
	 */
	@Test
	public void testHibernateCache(){
		
		UserInfo s1 =(UserInfo) session.get(UserInfo.class,"1");
		System.out.println(s1.getFullname());
		//session.clear(); // 清楚session所有对象  
		//session.evict(s1); //将某个对象从session的一级缓存中清除
		UserInfo s2 =(UserInfo) session.get(UserInfo.class,"1");
		System.out.println(s2.getFullname());
		
		// 查询，并把结果保存在二级缓存
		session.createQuery("").setCacheable(true);
	}
	
	/**
	 * 继承
	 * @MappedSuperclass
       @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	 * @throws IOException 
	 */
	
	/**
	 * 懒加载
	 * @throws IOException 
	 * @throws SQLException 
	 */
	
	/*
	 * 数据类型 java.util.Date/java.sql.Date 年月日时分秒 
	 *         Date 年月日
	 *         time  时分秒
	 *         Timestamp  年月日时分秒
	 *         
	 *    映射类型      Java类型           标准SQL类型    MYSQL类型   Oracle类型
	 *    binary       byte[]         varchar/blob   blob       blob
	 *    text     java.lang.String      clob        text       clob
	 *    clob     java.sql.Clob         CLOB        TEXT       CLOB
	 *    blob     java.sql.Blob         blob        blob       blob
	 *    
	 *    binary  字节数组
	 *    text clob  大文本数据类型
	 *    blob    二进制数据类型  (音频/视频/图片)
	 *    
	 *    mysql 不支持SQL的clob类型，在Mysql中，用txt,mediumtext, longtext 类型标示长度超过255的文本长度。
	 *    
	 */
	//@Test
	public void testWriteLob() throws IOException, SQLException{
		UserInfo user = new UserInfo("3","3","3","3","3","3","3");
		user.setBirthday(new Date());
		File f = new File("d:"+File.separator+"s.bmp");
		InputStream input = new FileInputStream(f);
		Blob blob =  Hibernate.getLobCreator(session).createBlob(input,input.available());
		blob.setBinaryStream(input.available());
		user.setPictrue(blob);
		session.save(user);
	}
	//@Test
	public void testReadLob() throws SQLException, IOException{
		UserInfo user = (UserInfo) session.get(UserInfo.class, "1");
		Blob blob = user.getPictrue();
		InputStream input = blob.getBinaryStream();
		File f = new File("D:"+File.separator+"A.bmp");
		OutputStream output = new FileOutputStream(f);
		byte[] buff = new byte[input.available()];
		input.read(buff);
		output.write(buff);
		input.close();
		output.close();
	}
	
	/*
	 * 测试组建属性
	 */
	@Test
	public void testAdressPro(){
		UserInfo user = new UserInfo("5","4","4","4","4","4","4");
		Address address = new Address();
		address.setAddress("复兴门");
		address.setPhone("11111");
		user.setAddress(address);
		session.save(user);
	}
	
}
