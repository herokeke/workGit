package gofmodel.Memento;

public class Person {
	
	private String name;
	
	private int age;
	
	private String sex;

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

	public Person(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	//创建一个备份
	public Memento createMemento(){
		
		return new  Memento(name,age,sex);
		
	}
	
	//恢复一个备份
	public void recoverMemento(Memento memento){
		
		this.name = memento.getName();
		this.age = memento.getAge();
		this.sex = memento.getSex();
		
	}

	public void display(){
		System.out.println(this.name+this.age+this.sex);
	}
}
