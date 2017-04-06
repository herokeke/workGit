package common.classUtil.thread.normal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadCall {
	
	public static void main(String[] args){
		ExcuteStatic es = new ExcuteStatic();
		  for (int i=0; i<200; i++) {
			  new Thread(es).start();
		  }
	}

}

class ExcuteStatic implements Runnable{
	
	/*
	 * 【强制】线程池不允许使用 Executors去创建，而是通过 ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
	 * 说明：Executors返回的线程池对象的弊端如下： 
		1）FixedThreadPool和 SingleThreadPool: 
		      允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。 
		2）CachedThreadPool和 ScheduledThreadPool: 
		      允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
	 */
	//public static ExecutorService service = Executors.newCachedThreadPool();//java.util.concurrent包里
	
	public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(8, 16, 32, TimeUnit.SECONDS,
			 new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.AbortPolicy());
	
    public static int num = 0;
    
	public static void excute(){
		num=3;
	//	System.out.println(Thread.currentThread().getName()+"<=======>"+num);
		num=5;
	//	 System.out.println(Thread.currentThread().getName()+"<=======>"+num*2);
		//ExecutorService service = Executors.newCachedThreadPool();//java.util.concurrent包里
		 ProcessorCall pc = new ProcessorCall();
		  for (int i=0; i<500; i++) {
			 // Future<String> future =  service.submit(new ProcessorCall());
			  Future<String> future = threadPool.submit(new ProcessorCall());
			try {
				System.out.println("当前线程池大小："+threadPool.getPoolSize()+";future=="+(String)future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }  
		  // static 修饰的变量 会有线程安全问题，导致shutdown 报 java.util.concurrent.RejectedExecutionException 异常。
		  // service.shutdown();
		  // threadPool.shutdown();
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