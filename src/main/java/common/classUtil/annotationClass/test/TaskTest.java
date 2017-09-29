package common.classUtil.annotationClass.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;

import common.classUtil.annotationClass.Table;
import common.classUtil.annotationClass.bean.TaskBean;


public class TaskTest {
  public static void main(String[] args){
	TaskBean t1 = new TaskBean("001","大娃",4,"男");
	TaskBean t2 = new TaskBean("002","二娃",3,"");
	TaskBean t3 = new TaskBean("003","三娃",2,"男");
	TaskBean t4 = new TaskBean("004","四娃",1,"男");
	  TaskImpl task = new TaskImpl();
	  task.save(t1);
	  task.save(t2);
	  task.save(t3); 
	  task.save(t4);
	  task.find(t1);
	  task.find(t2);
	  task.find(t3);
	  task.find(t4);
	  
  }
   
}
// @Inherited  只适用于继承关系，只能继承类上的注解。 父类进行了注解，通过未注解子类可以获取父类的注解信息。

class TaskTestChild{
	public static void main(String[] args){
		TaskBeanChild tbc = new TaskBeanChild();
		Annotation[] ann = tbc.getClass().getAnnotations();
		for(Annotation an : ann){
			if(an instanceof Table){
				Table t = (Table) an;
				System.out.println(t.name());
			}
			
			
		}
		
	}
}
