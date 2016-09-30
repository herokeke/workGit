package common.classUtil.testClass;

import java.lang.reflect.Field;

public class TestArrays {
	
    public static void main(String[] args) {
    	String[] agr = new String[]{"aaaa","ddddd","11","11"};
    	String parm="";
    	for(String s: agr){
    		System.out.println(s.equals(parm));
    		System.out.println(s+"<>hash:"+s.hashCode());
    		parm = s;
    	}
    } 
	

}
class Parent1{
	 public Parent1(){
			
		}
    public Parent1(String a){
		
	}
	public Parent1(String a,String b){
		this("a");
	}
}
class  Parent2 extends Parent1{
	
}
class Parent3 extends Parent2{

}
