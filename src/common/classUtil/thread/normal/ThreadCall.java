package common.classUtil.thread.normal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadCall {
	
	public static void main(String[] args){
		ExcuteStatic es = new ExcuteStatic();
		  for (int i=0; i<100; i++) {
			  new Thread(es).start();
		  }
	}

}

class ExcuteStatic implements Runnable{
	
	//public static ExecutorService service = Executors.newCachedThreadPool();//java.util.concurrent包里
    public static int num = 0;
	public static void excute(){
		num=3;
	//	System.out.println(Thread.currentThread().getName()+"<=======>"+num);
		num=5;
	//	 System.out.println(Thread.currentThread().getName()+"<=======>"+num*2);
		ExecutorService service = Executors.newCachedThreadPool();//java.util.concurrent包里
		 ProcessorCall pc = new ProcessorCall();
		  for (int i=0; i<5; i++) {
			  Future<String> future =  service.submit(new ProcessorCall());
			try {
				System.out.println("future=="+(String)future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }  
		  service.shutdown();
	}
	@Override
	public void run() {
		excute();
		
	}
}


class ProcessorCall implements Callable<String>{

	@Override
	public String call() throws Exception {
		  for (int i=0; i<5; i++) {
              System.out.println(Thread.currentThread().getName() + "," + i);
       }  
		return "执行成功";
	}
	
}