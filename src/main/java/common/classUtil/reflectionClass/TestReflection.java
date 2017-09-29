package common.classUtil.reflectionClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		//第一种方式
		Class c1 =  Class.forName("common.classUtil.reflectionClass.User");
		System.out.println(c1.newInstance());
		//第二种方式
		Class c2 = common.classUtil.reflectionClass.User.class;
		System.out.println(c2.newInstance());
		//第三种方式
		User u = new User();
		Class c3 = u.getClass();
		System.out.println(c3.newInstance());
		System.out.println(c1==c2); //true
		System.out.println(c1==c3); //true

		//1.	Constructor
		//获取类对象的公共构造方法
		Constructor[] cs =  c3.getConstructors();
		//获取对象的所有构造方法
		cs =  c3.getDeclaredConstructors();
		for(Constructor c:cs){
			Class[] paramClasses  = c.getParameterTypes();
			String param = "";
			for(Class cl:paramClasses){
				param +=cl.getName()+" ";
			}
			System.out.println(Modifier.toString(c.getModifiers())+" "+c.getName()+"("+param+")");
		}

		//2.	Method
		Method[] mClass = c2.getDeclaredMethods();
		for(Method md: mClass){
			Class[] paramClasses  = md.getParameterTypes();
			String param = "";
			for(Class cl:paramClasses){
				param +=cl.getName()+" ";
			}
			System.out.println("method:"+Modifier.toString(md.getModifiers())+" "+md.getName()+"("+param+")");

		}

		Method m = null;//c2.getMethod("getDep"); //无参数
		m = c2.getMethod("getDep",String.class);
		if(Modifier.isStatic(m.getModifiers())){
			System.out.println(Modifier.toString(m.getModifiers()));
			// m.invoke(null); //public static
		}else{
			Object obj =null;// m.invoke(c2.newInstance()); //无参数
			obj = m.invoke(c2.newInstance(),"");
			System.out.println(obj);

		}

		//3.	Field
		Field[] fe = c1.getDeclaredFields();
		for(Field f:fe){
			System.out.println("Field:"+Modifier.toString(f.getModifiers())+" "+f.getType().getName()+" "+f.getName());
			if(!Modifier.isPrivate(f.getModifiers())){
				System.out.println(f.get(c1.newInstance()));
			}

		}
		Field f = c1.getDeclaredField("name");
		Object obj = c1.newInstance();
		//类中的成员变量为private,故必须进行此操作
		f.setAccessible(true);
		f.set(obj,"中共中央");
		System.out.println("Field=>"+f.get(obj));


		//4. class
		// 获取类对象
		Class empClass = Class.forName( "java.lang.String" );
		// 类的修饰符
		System.out.println( "类的修饰符:" + Modifier.toString(empClass.getModifiers()) );
		System.out.println( "类的名称:" + empClass.getName() );
		System.out.println( "类的简称:" + empClass.getSimpleName() );
		System.out.println( "类的包:" + empClass.getPackage().getName() );
		System.out.println( "类的父类:" + empClass.getSuperclass().getName() );
		Class[] ifClasses = empClass.getInterfaces();
		for ( Class c : ifClasses ) {
			System.out.println( "类的接口:" + c.getName() );
		}
		System.out.println( "类是不是数组:" + empClass.isArray() );

	}

}

class User{
	private String name;
	private int age;
	public String group="上地";

	public User(){
		System.out.println("无参构造 newInstance");
	}
	public User(String name){
		System.out.println("无参构造 newInstance");
	}
	private User(String name,Integer age){
		System.out.println("无参构造 newInstance");
	}

	public  String getDep(String mgs){
		if("".equals(mgs)){
			return "无党派组织";
		}
		return "党支部";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}