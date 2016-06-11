package test;

public class NeiBuClass {
	 public void test(final int b) {
	        final int a = 10;
	        new Thread(){ //匿名内部类
	            public void run() { // run 由现场调用
	                System.out.println(a);
	                System.out.println(b);
	            };
	        }.start(); // 可以直接调用，也可以用对象调用。
	    }
	 public static void main(String[] args)  {
		 // 访问内部类的方式
	        //第一种方式：
	        Outter outter = new Outter();
	        Outter.Inner inner = outter.new Inner();  //必须通过Outter对象来创建
	        //第二种方式：
	        Outter.Inner inner1 = outter.getInnerInstance();
	        //第三种方式：静态内部类。
	    }
}

class Outter {
    private Inner inner = null;
    public Outter() {
    }
    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }
    class Inner {
        public Inner() {
        	System.out.println("Inner已创建");
        }
    }
}