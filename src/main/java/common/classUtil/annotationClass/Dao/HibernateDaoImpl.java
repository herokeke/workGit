package common.classUtil.annotationClass.Dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import common.classUtil.annotationClass.Column;
import common.classUtil.annotationClass.Table;

public class HibernateDaoImpl<T> implements IDao<T> {


	public void find(T entity) {
		Class c = entity.getClass();
		StringBuffer sbf =  new StringBuffer();
		StringBuffer sbfwhere =  new StringBuffer();
		sbf.append(" select * from ");
		String stable ="";
		String scolumn="";
		Table table = (Table) c.getAnnotation(Table.class);
		if(table!=null)stable = table.name();
		Method[] methods = c.getMethods();
		for(Method m: methods){
			Column col =  m.getAnnotation(Column.class);
			if(col!= null){
				scolumn = col.name();
			}
			try {
				if(m.getName().startsWith("get")&&!m.getName().equals("getClass")){
					Object obj = m.invoke(entity);
					String parm = "" ;
					if(obj instanceof String){
						parm = "'"+obj.toString()+"'";
					}
                    if(obj instanceof Integer){
                    	parm = obj.toString();
					}
                    if(obj!=null){
                    	sbfwhere.append(" and ");
						sbfwhere.append(scolumn).append("=").append(parm);
					}
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sbf.append(stable).append(" where 1=1  ").append(sbfwhere);
		System.out.println(sbf.toString());
	}


	public void save(T entity) {
		Class c = entity.getClass();
		StringBuffer sbf =  new StringBuffer();
		StringBuffer sbfkey =  new StringBuffer();
		StringBuffer sbfvalue =  new StringBuffer();
		sbf.append(" insert into ");
		String stable ="";
		Table table = (Table) c.getAnnotation(Table.class);
		if(table!=null)stable = table.name();
		Method[] methods = c.getMethods();
		for(Method m: methods){
			Column col =  m.getAnnotation(Column.class);
			if(col!= null){
				sbfkey.append(","+col.name());
			}
			try {
				if(m.getName().startsWith("get")&&!m.getName().equals("getClass")){
					Object obj = m.invoke(entity);
					 sbfvalue.append(",");
					if(obj instanceof String){
						sbfvalue.append("\'"+obj.toString()+"\'");
					}
                    if(obj instanceof Integer){
                    	sbfvalue.append(obj.toString());
					}
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sbf.append(stable).append("("+sbfkey.substring(1)+")").append(" values ").append("("+sbfvalue.substring(1)+");");
		System.out.println(sbf.toString());
		
	}

}
