package common.classUtil.cloneClass;

public class Address  implements Cloneable {
	
  private  String address;
  private  String phone;
  
	public Address(String address, String phone) {
	super();
	this.address = address;
	this.phone = phone;
}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	  
	 public Address clone(){
		 Address address = null;
			 try {
				 address = (Address) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return address;
		 }
}
