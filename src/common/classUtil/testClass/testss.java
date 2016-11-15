package common.classUtil.testClass;


public class Testss {
	
	private static ThreadLocal actionContext = new ThreadLocal();
	
	public Testss(){
		System.out.println("testss");
	}
	private static MyTest mt = new MyTest();

	public static Testss gettestss(){
		System.out.println("actionContext>"+(actionContext.get() instanceof Testss));
		Testss  tt = (Testss) actionContext.get();
		System.out.println("tt="+tt);
		return tt;
	}
	public static void fun(){
		System.out.println("why??");
		mt.fun();
	}
	public static void excute(){
		System.out.println("excute");
	}
	public static void main(String[] args){
		//System.out.println(Testss.class.hashCode());
		Object o = Testss.gettestss();
		int i=0;
		while(true){
			//System.out.println(Testss.gettestss().toString());
			//System.out.println("000>>"+Thread.currentThread().getName());
			System.out.println("000>>"+Testss.gettestss());
		//	Testss.gettestss().excute();
			//Testss.fun();
			if(i==10){
				return; 
			}
			i++;
		}
	
	}
	
	 protected void finalize(){
		 System.out.println("gc");
	 }
	

	
}
class MyTest{
	public MyTest(){
		System.out.println("mytest");
	}
	public void fun(){
		System.out.println("fun");
	}
}