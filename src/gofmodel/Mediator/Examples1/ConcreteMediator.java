package gofmodel.Mediator.Examples1;

public class ConcreteMediator implements Mediator {

	private ConcreteColleagueB concreteColleagueb;
	private ConcreteColleagueA concreteColleaguea;
	//private ConcreteColleague* ... 也行N多个的对象，将复杂的对象关系通过中介进行管理起来。 
	
	public ConcreteColleagueB getConcreteColleagueb() {
		return concreteColleagueb;
	}

	public void setConcreteColleagueb(ConcreteColleagueB concreteColleagueb) {
		this.concreteColleagueb = concreteColleagueb;
	}

	public ConcreteColleagueA getConcreteColleaguea() {
		return concreteColleaguea;
	}

	public void setConcreteColleaguea(ConcreteColleagueA concreteColleaguea) {
		this.concreteColleaguea = concreteColleaguea;
	}

	@Override
	// 将原本属于 A and  B 的 实现的方法进行提取。在中介的实现中去执行。
	public void excute() {
		// TODO Auto-generated method stub

	}

}
