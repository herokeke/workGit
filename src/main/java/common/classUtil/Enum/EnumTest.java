package common.classUtil.Enum;


public final class EnumTest {
	public static void fun(Season s){
		  System.out.println(s.getName()+"这个季节"+s.getDeac()+"DD");
	}
    public static void main(String[] args) {
    	fun(Season.FALL);
    }
}
class Season{ 
	private final String name;
	private final String deac;
	public static final Season SPRING = new Season("春天","秋高气爽");
	public static final Season SUMMER = new Season("夏天","夏日炎炎");
	public static final Season FALL = new Season("秋天","秋高气爽");
	public static final Season WINTER = new Season("冬天","炉旁赏雪");
	private Season(String name,String deac){
		this.name=name;
		this.deac=deac;
	}
	private Season(){ //final修饰的变量调用之前需要进行初始化�??
		this.name="";
		this.deac="";
	}
	
	public String getName(){
		return this.name;
	}
	public String getDeac(){
		return this.deac;
	}
}

enum SeasonEnum{
	SPRING,SUMMER,FALL,MINTER;
}

class TestEnum{
	public static void fun(SeasonEnum e){
		switch(e){
		case  SPRING:System.out.println("�?");break;
		case  SUMMER:System.out.println("�?");break;
		case  FALL:System.out.println("�?");break;
		case  MINTER:System.out.println("�?");break;
		
		
		}
	}
	public static void main(String[] args) {
		for(SeasonEnum se:SeasonEnum.values()){
			fun(se);
		}
    	
    }
}