package common.classUtil.testWork;

import java.lang.reflect.Field;

public class Test {
	
	static void change(String str){
		 try {
	            Class<?> clazz = str.getClass();
	            Field field = clazz.getDeclaredField("value");
	            field.setAccessible(true);
	            Object obj = field.get(str);
	            char [] charValue = (char [] )obj;
	            for(char c:charValue){
	            	 System.out.println("objValue=>"+c);
	            }
	            charValue = new char [4];
	            for(int i=0;i<charValue.length;i++){
	                charValue[i]='a';
	            }
	             Field field1 = clazz.getDeclaredField("count");
	             field1.setAccessible(true);
	             
	             field1.set(str, charValue.length);
	             field.set(str, charValue);
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
     
    public static void main(String[] args) {
      String a = new String("aa");
      String b = new String("aa");
      String c="aa";
      String d="aa";
      System.out.println(a==b);
      System.out.println(a.equals(b));
      System.out.println(c==d);
      System.out.println(c.equals(a));
      
    } 
	
//Comparable
}
