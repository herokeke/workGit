package test;

public class NeiBuClass {
	 public void test(final int b) {
	        final int a = 10;
	        new Thread(){ //�����ڲ���
	            public void run() { // run ���ֳ�����
	                System.out.println(a);
	                System.out.println(b);
	            };
	        }.start(); // ����ֱ�ӵ��ã�Ҳ�����ö�����á�
	    }
	 public static void main(String[] args)  {
		 // �����ڲ���ķ�ʽ
	        //��һ�ַ�ʽ��
	        Outter outter = new Outter();
	        Outter.Inner inner = outter.new Inner();  //����ͨ��Outter����������
	        //�ڶ��ַ�ʽ��
	        Outter.Inner inner1 = outter.getInnerInstance();
	        //�����ַ�ʽ����̬�ڲ��ࡣ
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
        	System.out.println("Inner�Ѵ���");
        }
    }
}