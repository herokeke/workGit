package common.classUtil.reflectionClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestReflection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException{
		//��һ�ַ�ʽ
		Class c1 =  Class.forName("common.classUtil.reflectionClass.User");
		System.out.println(c1.newInstance());
		//�ڶ��ַ�ʽ
		Class c2 = common.classUtil.reflectionClass.User.class;
		System.out.println(c2.newInstance());
		//�����ַ�ʽ
		User u = new User();
		Class c3 = u.getClass();
		System.out.println(c3.newInstance());
		System.out.println(c1==c2); //true
		System.out.println(c1==c3); //true
		
		//1.	Constructor
		//��ȡ�����Ĺ������췽��
		Constructor[] cs =  c3.getConstructors();
		//��ȡ��������й��췽��
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
		
		Method m = null;//c2.getMethod("getDep"); //�޲���
		m = c2.getMethod("getDep",String.class);
		if(Modifier.isStatic(m.getModifiers())){
		   	System.out.println(Modifier.toString(m.getModifiers()));
			// m.invoke(null); //public static
		}else{
			Object obj =null;// m.invoke(c2.newInstance()); //�޲���
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
		//���еĳ�Ա����Ϊprivate,�ʱ�����д˲��� 
		f.setAccessible(true);
		f.set(obj,"�й�����");
		System.out.println("Field=>"+f.get(obj));
		
		
		//4. class
		  // ��ȡ�����
        Class empClass = Class.forName( "java.lang.String" );
        // ������η�
        System.out.println( "������η�:" + Modifier.toString(empClass.getModifiers()) );
        System.out.println( "�������:" + empClass.getName() );
        System.out.println( "��ļ��:" + empClass.getSimpleName() );
        System.out.println( "��İ�:" + empClass.getPackage().getName() );
        System.out.println( "��ĸ���:" + empClass.getSuperclass().getName() );
        Class[] ifClasses = empClass.getInterfaces();
        for ( Class c : ifClasses ) {
            System.out.println( "��Ľӿ�:" + c.getName() );
        }
        System.out.println( "���ǲ�������:" + empClass.isArray() );

	} 
	
}

class User{
	private String name;
	private int age;
	public String group="�ϵ�";
	
	public User(){
		System.out.println("�޲ι��� newInstance");
	}
	public User(String name){
		System.out.println("�޲ι��� newInstance");
	}
	private User(String name,Integer age){
		System.out.println("�޲ι��� newInstance");
	}
	
	public  String getDep(String mgs){
		if("".equals(mgs)){
			return "�޵�����֯";
		}
		return "��֧��";
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