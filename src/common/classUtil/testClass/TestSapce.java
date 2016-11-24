package common.classUtil.testClass;


public class TestSapce {

	public static void main(String[] args){
		Sapce s = new SapceSub();
		System.out.println(s.a); //10
		s.fun();
		
		Sapce[] sps = new Sapce[]{s};
		Sapce[] spclone = new Sapce[1];
		System.arraycopy(sps, 0, spclone, 0, 1);
		spclone[0].a=99;
		System.out.println();
		System.out.println(s.a); //10
		
		Sapce b = s;
		Sapce c = new Sapce();
		c = s;
		b.a=5;
		System.out.println(s.equals(b)); //true
		System.out.println(s==b); //true
		System.out.println(s.equals(c)); //true
		System.out.println(s==c); //true
		System.out.println(s.a); // 5
		System.out.println("=====");
		System.out.println(TestSapce.class.getResource("/"));
		System.out.println(TestSapce.class.getResource("/").getPath());
		
	}
}
class Sapce{
	int a=10;
	public void fun(){
		System.out.println("this is Sapce");
	}
}
class SapceSub extends Sapce{
	int a=15;
public void fun(){
	System.out.println("this is SapceSub");
	}
}