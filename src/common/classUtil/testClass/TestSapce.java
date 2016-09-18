package common.classUtil.testClass;

public class TestSapce {

	public static void main(String[] args){
		Sapce s = new Sapce();
		System.out.println(s.a);
		Sapce b = s;
		Sapce c = new Sapce();
		c = s;
		b.a=5;
		System.out.println(s.equals(b));
		System.out.println(s==b);
		System.out.println(s.equals(c));
		System.out.println(s==c);
		System.out.println(s.a);
		System.out.println("=====");
		
		
		
	}
}
class Sapce{
	int a=10;
}
class SapceSub extends Sapce{
	int a=15;
}