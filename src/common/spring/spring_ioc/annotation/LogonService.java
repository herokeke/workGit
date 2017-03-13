package common.spring.spring_ioc.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.spring.spring_ioc.annotation.ext.Plugin;

@Service
public class LogonService {
	
	// 默认按照类型匹配的方式，在容器中查找匹配的Bean,当有且仅有一个匹配的Bean时，spring将其注入到@Autowired标注的Bean中。
   @Autowired
   private UserDao userDao;
   
   //如果容器中一个以上匹配的Bean时，可以通过@Qualifier注解限定Bean的名称。
   @Autowired
   @Qualifier("extUserDao")
   private IDao idao;
   
   //如果对类中集合类的变量或方法入参进行 @Autowired标注，Spring会将容器中类型匹配的所有Bean都自动注入进来。
   @Autowired(required=false)
   private List<Plugin> plugin;
   
   /*如果容器中没有一个和标注类型匹配的Bean，Spring 容器启动时将报 org.springframework.beans.factory.NoSuchBeanDefinitionException
   的异常,如果希望Spring即使找不到匹配的Bean完成注入也不会报异常，那么可以使用(required=false) 进行标注。
   */
   @Autowired(required=false)
   private LogDao logDao;
   
   // 
   @Autowired
   @Qualifier("extUserDao")
   public void setUserDao(IDao idao){
	   idao.addUser();
   }
   
   @Autowired
   public void setUserDao(@Qualifier("extUserDao")IDao idao1,@Qualifier("userDao")IDao idao2){
	   idao1.addUser();
	   idao2.addUser();
   }
   
   @Autowired
   public void setLogDao(LogDao logDao){
	   logDao.addLog();
   }
   
   public void excute(){
	   userDao.addUser();
	 //  logDao.addLog(); 
	   idao.addUser();
   }
   
   public void plugin(){
	   for(Plugin p :plugin){
		   p.excute();
	   }
   }
}
