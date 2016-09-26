package common.classUtil.cloneClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class CloneTest {
	
	/*
	 *  浅度克隆 
	 *  必须实现 Cloneable 否则抛出 java.lang.CloneNotSupportedException
	 */
	
	@Test
	public void testCloneQ(){
		
		UserBean ub = new UserBean("大娃",8,new String[]{"1","1","1"});
		ub.setAddress(new Address("南礼士路","138"));
		/*
		 * 引用传递  实际的内存地址会进行传递。两个引用指向同一个对象
		 * UserBean ub1 =ub;
		 * ub1.setName("二娃");
		 */
		UserBean ubClone = ub.clone();
		ubClone.setName("二娃");
		ubClone.setAge(7);
		/*
		 * ubClone 是克隆后的对象，有新的内存地址。
		 * 但对象内的 属性没有进行克隆，只有一份内存地址。
		 */
		ubClone.getBwh()[0]="3";
		ubClone.getBwh()[1]="3";
		ubClone.getBwh()[2]="3";
		ubClone.getAddress().setAddress("复兴门");
		ubClone.getAddress().setPhone("137");
		/*
		 * ubClone 是克隆后的对象，有新的内存地址。通过 setter 近 new 对象不会影响 原对象。
		 * ubClone.setBwh(new String[]{"2","2","2"});
		 * ubClone.setAddress(new Address("复兴门","137"));
		 */
	
	//	
		System.out.println("姓名："+ub.getName()+";年龄："+ub.getAge()+";三围："+ub.getBwh()[0]+ub.getBwh()[1]+ub.getBwh()[2]+ub.getAddress().getAddress());
		System.out.println("姓名："+ubClone.getName()+";年龄："+ubClone.getAge()+";三围："+ubClone.getBwh()[0]+ubClone.getBwh()[1]+ubClone.getBwh()[2]+ubClone.getAddress().getAddress());
		
	}
	
	/*
	 * 深度克隆 
	 * 
	 */ 
	@Test
	public void testCloneS(){
		
	}
	
	/*
	 * Java利用序列化实现对象深度clone的方法,
	 * 必须要实现Serializable 接口 否则抛出 java.io.NotSerializableException
	 */ 
	 
	@Test
	public void testCloneX() throws IOException, ClassNotFoundException{
		//TODO  ByteArrayOutputStream  ObjectOutputStream IO 在研究下
		 UserBean user = new UserBean("大姨",18,new String[]{"9","9","9"});
		 ByteArrayOutputStream  byteOut = new ByteArrayOutputStream();  
         ObjectOutputStream out = new ObjectOutputStream(byteOut);  
         out.writeObject(user);         
         ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());  
         ObjectInputStream in =new ObjectInputStream(byteIn);        
         UserBean userClone   = (UserBean) in.readObject();
         userClone.setName("二姨");
         userClone.setAge(15);
         userClone.setBwh(new String[]{"8","8","8"});
     	System.out.println("姓名："+user.getName()+";年龄："+user.getAge()+";三围："+user.getBwh()[0]+user.getBwh()[1]+user.getBwh()[2]);
    	System.out.println("姓名："+userClone.getName()+";年龄："+userClone.getAge()+";三围："+userClone.getBwh()[0]+userClone.getBwh()[1]+userClone.getBwh()[2]);
		
		
	}

}
