package gofmodel.factory.AbstractFactory;

public class CyanFactory implements FruitFactory {

	@Override
	public Fruit getApple() {
		return new CyanApple();
	}

	@Override
	public Fruit getBanana() {
		return new CyanBanana();
	}

}
