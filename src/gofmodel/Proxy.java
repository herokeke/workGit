package gofmodel;

/**
 * 代理模式
 * @author cxy
 */
public class Proxy {
    public static void main(String[] args){
    	// 默认构造 是 悟空。可以带参构造出 八戒和 沙僧。
    	TangShengPorxy tsp = new  TangShengPorxy(); 
    	tsp.chuanJiao();
    	tsp.shaGuai();
    	tsp.huYan();
    }
}
/**
 * 面向对象设计，每一个取经人都有其共同的属性 就是化缘 传教 打击犯罪
 * @author Administrator
 *
 */
interface QuJing{
	 public String huYan();
	 public void shaGuai();
	 public void chuanJiao();
	 
}

/**
 * 悟空本领高强，适合体力劳动，可以进行与歹徒搏斗，去弄路上的食物。不善于文案工作。
 * @author Administrator
 *
 */
class WuKong implements QuJing{

	// 听到“经书”这两字 头都大。
	public void chuanJiao() {
		System.out.println("不会念经的悟空!!");
		
	}
    //开小灶，偶尔能吃肉，哈哈
	public String huYan() {
		
		return "一锅斋饭";
	}
    //我的擅长
	public void shaGuai() {
		System.out.println("悟空已经大杀特杀");
		
	}
	
}

/**
 * 唐生 腿脚不利索，胆小怕事，不适合危险活动。但是作为领导人，上级派的活必须要接。
 * 这时唐生想到了悟空，自己不用动手就能完成领导的工作。这就相当于悟空的代理了，
 * 最后交差的领赏的是唐生啊。发现现在的代理很赚钱啊，各种微商，各种中介，各种代购。
 * 唐生确实很强，能把能人义士都留在了自己的身边。团队是强大的，关键是团队中能聚拢人心的最关键人物。
 * @author Administrator
 *
 */
class TangShengPorxy implements QuJing{
	
	// 核心的关键，不面向对象，面向接口。
    private QuJing quJing;  
    
    public TangShengPorxy(){
    	this.quJing = new WuKong();//把悟空拉进来，有事的时候就上
    }
    
    public TangShengPorxy(QuJing quJing){ // 可以把 八戒 沙僧 都拉进来。
    	this.quJing = quJing;
    }
    
    //白领的工作我来
	public void chuanJiao() {
		System.out.println("唐生亲自授课");
		
	}
    //这等 危险悟空上
	public String huYan() {
		System.out.println(this.quJing.huYan());
		return this.quJing.huYan(); // 面向对象的真谛啊，最终面向的是接口
	}
    //罪过罪过 悟空上
	public void shaGuai() {
		 this.quJing.shaGuai();  // 面向对象的真谛啊，最终面向的是接口
		
	}
}
