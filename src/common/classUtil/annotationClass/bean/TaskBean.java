package common.classUtil.annotationClass.bean;

import common.classUtil.annotationClass.Column;
import common.classUtil.annotationClass.Table;

@Table(name="TASK_BEAN")
public class TaskBean {

	private String id;
	
	private String name;
	
	private Integer age;
	
	private String sex;
	
	public TaskBean(){
		
	}
	public TaskBean(String id, String name, Integer age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	@Column(name="TASK_ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="TASK_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="TASK_AGE")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name="TASK_SEX")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
