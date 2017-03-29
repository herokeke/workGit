package common.classUtil.testWork;


public class Testold {
	
	private static ThreadLocal actionContext = new ThreadLocal();
	
	public Testold(){
		System.out.println("testss");
	}
	private static MyTest mt = new MyTest();

	public static Testold gettestss(){
		System.out.println("actionContext>"+(actionContext.get() instanceof Testold));
		Testold  tt = (Testold) actionContext.get();
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
		Object o = Testold.gettestss();
		int i=0;
		while(true){
			//System.out.println(Testss.gettestss().toString());
			//System.out.println("000>>"+Thread.currentThread().getName());
			System.out.println("000>>"+Testold.gettestss());
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