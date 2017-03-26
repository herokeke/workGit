package common.classUtil.thread.normal;

public class ThreadJoin {
	
	 public static void main(String[] args) {
         Runnable r1 = new Processor();
         Thread t1 = new Thread(r1, "t1");
         t1.start();
        
         try {
        	 
        	 /*
        	  * 调用后当前线程(main)会被阻塞不再执行，直到被调用的线程(t1)执行完毕，当前线程(main)才会执行
        	  */
                t1.join();
         }catch(InterruptedException e) {
                e.printStackTrace();      
         }
         System.out.println("===>"+Thread.currentThread().getName());
         System.out.println("------main end-------");
  }    
}

class Processor implements Runnable {
 
  public void run() {
         for (int i=0; i<10; i++) {
                System.out.println(Thread.currentThread().getName() + "," + i);
         }    
  }    
}
