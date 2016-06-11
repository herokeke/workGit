package test;

public class BeanClass {
	 public static void main(String[] args){
		 //成员内部类
		 BeanClass.Bean1 bean1 =(new BeanClass()).new Bean1(); 
         bean1.I++;
         //静态内部类
         BeanClass.Bean2 bean2 =new BeanClass.Bean2();
         bean2.J++;
         //局部内部类
         Bean.Bean3 bean3 =(new Bean()).new Bean3();
         bean3.k++;
         //私有内部类与成员无异。
         BeanClass.Bean4 bean4 =(new BeanClass()).new Bean4();
         bean4.M++;
  }
  class Bean1{
         public int I = 0;
  }
  static class Bean2{
         public int J = 0;
  }
  private class Bean4{
	  public int M = 0;
  }
}
class Bean{
    class Bean3{
           public int k = 0;
    }
}