package common.classUtil.cloneClass;

import java.io.Serializable;

public class UserBean implements Cloneable , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4529426657981261348L;
	private String name;
	private Integer age;
	private String[] bwh; //三围
	private Address address; // 通讯地址电话
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String[] getBwh() {
		return bwh;
	}
	public void setBwh(String[] bwh) {
		this.bwh = bwh;
	}
	public UserBean(String name, Integer age, String[] bwh) {
		super();
		this.name = name;
		this.age = age;
		this.bwh = bwh;
	}
	public UserBean(){
		
	}
	 public UserBean clone(){
		UserBean userBean = null;
		 try {
			 userBean = (UserBean) super.clone();
			 /*
			  * 其实内部的属性 进一步克隆 实现 深度克隆
			  */
			 bwh  = bwh.clone(); 
			 address = address.clone(); // address 要实现 Cloneable 否则无法进行 Clone
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return userBean;
	 }
}
