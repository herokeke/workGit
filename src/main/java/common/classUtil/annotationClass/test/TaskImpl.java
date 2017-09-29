package common.classUtil.annotationClass.test;

import common.classUtil.annotationClass.Dao.HibernateDaoImpl;
import common.classUtil.annotationClass.Dao.IDao;
import common.classUtil.annotationClass.bean.TaskBean;

public class TaskImpl {
	 private IDao<TaskBean> taskBeanDao = new HibernateDaoImpl<TaskBean>();
		
	   public void save(TaskBean taskBean){
		   taskBeanDao.save(taskBean);
	   }
	   public void find(TaskBean taskBean){
		   taskBeanDao.find(taskBean);
	   }
	   
	
}
