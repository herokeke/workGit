package test;

public class BeanClass {
	 public static void main(String[] args){
		 //��Ա�ڲ���
		 BeanClass.Bean1 bean1 =(new BeanClass()).new Bean1(); 
         bean1.I++;
         //��̬�ڲ���
         BeanClass.Bean2 bean2 =new BeanClass.Bean2();
         bean2.J++;
         //�ֲ��ڲ���
         Bean.Bean3 bean3 =(new Bean()).new Bean3();
         bean3.k++;
         //˽���ڲ������Ա���졣
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