package gofmodel.factory.AbstractFactory;

public class YellowFactory implements FruitFactory {

	@Override
	public Fruit getApple() {
		
		return new YellowApple();
	}

	@Override
	public Fruit getBanana() {
		// TODO Auto-generated method stub
		return new YellowBanana();
	}

}
