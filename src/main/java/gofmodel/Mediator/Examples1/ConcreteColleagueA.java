package gofmodel.Mediator.Examples1;

public class ConcreteColleagueA extends Colleague {

	public ConcreteColleagueA(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void findLove() {
		this.getMediator().excute();
	}

}
