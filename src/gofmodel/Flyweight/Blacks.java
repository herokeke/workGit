package gofmodel.Flyweight;

/**
 * 黑人
 * @author Administrator
 *
 */
public class Blacks implements Person {

	@Override
	public void operation(String state) {
		System.out.println("来自"+state+"的黑人。");
	}

}
