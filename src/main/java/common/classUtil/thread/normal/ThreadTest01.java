package common.classUtil.thread.normal;

public class ThreadTest01 {
	
	public static void method(){
		System.out.println("main--method--Thread");
	}
	/*
	 * 通过输出结果大家会看到，没有顺序执行，而在输出数字的同时执行了method()方法，如果从效率上看，
	 * 采用多线程的示例要快些，因为我们可以看作他是同时执行的，mthod1()方法没有等待前面的操作完成才执行，这叫“异步编程模型”
	 */
    public static void main(String[] args){
    	Processor01 p = new Processor01();
    	p.start();
    	method();
    	
    } 
}


class Processor01 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(i);
		}
	}
}