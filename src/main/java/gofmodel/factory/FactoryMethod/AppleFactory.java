package gofmodel.factory.FactoryMethod;



public class AppleFactory implements FruitFactory {

	@Override
	public Fruit getFruit() {
		return new Apple();
	}

}
