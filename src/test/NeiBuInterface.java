package test;

public class NeiBuInterface {
 public static void main(String[] args){
	 Persaon p = new Black();
	// p.run();
	new Persaon(){
			public void run(){
		          System.out.println("run����");		
			}
	 }.start();
	 
	 Animal a = new Animal(){
		 public void fun(){
			 System.out.println("������");
		 }
	 };
	 a.fun();
 }
}

abstract class  Persaon{
	public abstract void run();
	public void start(){
		System.out.println("start");
	}
}

class Black extends Persaon{
	public void run(){
          System.out.println("����");		
	}

	
}

interface Animal{
	public void fun();
}