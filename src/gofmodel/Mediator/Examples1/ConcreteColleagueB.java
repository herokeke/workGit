package gofmodel.Mediator.Examples1;

public class ConcreteColleagueB extends Colleague {

	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void findLove() {
		this.getMediator().excute();

	}

}
