package common.classUtil.thread.normal;

public class ThreadTest02 {
	public static void method(){
		System.out.println("main--method--Thread");
	}
    public static void main(String[] args){
    	Runnable p = new Processor02();
    //	Processor02 p = new Processor02();  //通常定义一个标记，来判断标记的状态停止线程的执行
    	//p.run();
    	Thread t1 = new Thread(p,"t1");
    	Thread t2 = new Thread(p,"t2");
    	t1.start();
    	t2.start();
    	t2.setPriority(Thread.MAX_PRIORITY); // 设置线程优先级
    	
//    	//通常定义一个标记，来判断标记的状态停止线程的执行
//    	try {
//		    Thread.sleep(1); //该线程代表main 函数入口的线程 睡眠影响method();
//	     } catch (InterruptedException e) {
//		   // TODO Auto-generated catch block
//		    e.printStackTrace();
//	    }
//    	p.setFlg(true);
    	
    	
//    	//当前线程可以调用另一个线程的join方法，调用后当前线程会被阻塞不再执行，直到被调用的线程执行完毕，当前线程才会执行
//    	try {
//			t1.join();//当前线程为main函数入口的线程 会最后执行method();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
//    	//如果我们的线程正在睡眠，可以采用interrupt进行中断
//    	try {
//    		Thread.sleep(1000); //该线程代表main 函数入口的线程 睡眠影响method();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//如果我们的线程正在睡眠，可以采用interrupt进行中断
//		t1.interrupt();
		
		
    	method();
    	
    } 
}
class Processor02 implements Runnable{
	private boolean flg;
	public void run(){
		for(int i=0;i<5;i++){
//			if("t2".equals(Thread.currentThread().getName())){
//				//它与sleep()类似，只是不能由用户指定暂停多长时间，并且yield()方法只能让同优先级的线程有执行的机会（机会增加，不代表肯定会）
//				Thread.yield();
//			}
			
			
//			try {
//				Thread.sleep(1000); // 线程t1 和线程 t2 同时执行
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//			//如果我们的线程正在睡眠，可以采用interrupt进行中断
//			if (i % 2 == 0) {
//				try {
//					Thread.sleep(3000);	
//				}catch(Exception e) {
//					System.out.println("-------中断-------");
//					break;				
//				}
//			}
			
			if (flg) {
				break;
			}
			
			System.out.println("ThreadName="+Thread.currentThread().getName()+";"+i);
		}
	}
	
	public void setFlg(boolean flg){
		this.flg=flg;
	}
}