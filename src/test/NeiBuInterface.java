package test;

public class NeiBuInterface {
 public static void main(String[] args){
	 Persaon p = new Black();
	// p.run();
	new Persaon(){
			public void run(){
		          System.out.println("run黑人");		
			}
	 }.start();
	 
	 Animal a = new Animal(){
		 public void fun(){
			 System.out.println("动物大会");
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
          System.out.println("黑人");		
	}

	
}

interface Animal{
	public void fun();
}