package common.classUtil.testClass;

public class testss implements Runnable {
	
	@Override
	public void run() {
	  System.out.println("执行");
	}

	public static void main(String[] args){
		Runnable  test = new testss();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		//t.setName("dd");
		
		t2.start();
		t1.start();
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		System.out.println(Thread.currentThread().getName());
		
	}

	
}
