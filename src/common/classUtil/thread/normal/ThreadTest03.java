package common.classUtil.thread.normal;

public class ThreadTest03 {
    public static void main(String[] args){
    	Runnable r1 = new Processor03();
    	Thread t1 = new Thread(r1,"t1");
    	t1.start();
    	Thread t2 = new Thread(r1,"t2");
    	t2.start();
    	
    } 
}
class Processor03 implements Runnable{
	int a =0;  //t1=55 t2=110
	public  void run(){
		synchronized(this){
			//int a =0;  // t1=55 t2=55
			for(int i=0;i<=10;i++){
				a+=i;
			}
			
		}
		System.out.println(Thread.currentThread().getName()+"="+a);
		a=0;
	}
}