package common.hibernate.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;


/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 322293115001601805L;
	private String pid;
	private String loginname;
	private String fullname;
	private String pwd;
	private String sex;
	private String mobile;
	private String phone;
	private Date birthday;
	private Blob pictrue; 
	private Address address;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public UserInfo(String pid, String loginname, String fullname, String pwd,
			String sex, String mobile, String phone) {
		super();
		this.pid = pid;
		this.loginname = loginname;
		this.fullname = fullname;
		this.pwd = pwd;
		this.sex = sex;
		this.mobile = mobile;
		this.phone = phone;
	}
	
	public UserInfo(){
		
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Blob getPictrue() {
		return pictrue;
	}
	public void setPictrue(Blob pictrue) {
		this.pictrue = pictrue;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	


}