package gofmodel;

/**
 * ����ģʽ
 * @author cxy
 */
public class Proxy {
    public static void main(String[] args){
    	// Ĭ�Ϲ��� �� ��ա����Դ��ι���� �˽�� ɳɮ��
    	TangShengPorxy tsp = new  TangShengPorxy(); 
    	tsp.chuanJiao();
    	tsp.shaGuai();
    	tsp.huYan();
    }
}
/**
 * ���������ƣ�ÿһ��ȡ���˶����乲ͬ������ ���ǻ�Ե ���� �������
 * @author Administrator
 *
 */
interface QuJing{
	 public String huYan();
	 public void shaGuai();
	 public void chuanJiao();
	 
}

/**
 * ��ձ����ǿ���ʺ������Ͷ������Խ������ͽ������ȥŪ·�ϵ�ʳ��������İ�������
 * @author Administrator
 *
 */
class WuKong implements QuJing{

	// ���������顱������ ͷ����
	public void chuanJiao() {
		System.out.println("����������!!");
		
	}
    //��С�ż���ܳ��⣬����
	public String huYan() {
		
		return "һ��ի��";
	}
    //�ҵ��ó�
	public void shaGuai() {
		System.out.println("����Ѿ���ɱ��ɱ");
		
	}
	
}

/**
 * ���� �ȽŲ���������С���£����ʺ�Σ�ջ��������Ϊ�쵼�ˣ��ϼ��ɵĻ����Ҫ�ӡ�
 * ��ʱ�����뵽����գ��Լ����ö��־�������쵼�Ĺ���������൱����յĴ����ˣ�
 * ��󽻲�����͵������������������ڵĴ����׬Ǯ��������΢�̣������н飬���ִ�����
 * ����ȷʵ��ǿ���ܰ�������ʿ���������Լ�����ߡ��Ŷ���ǿ��ģ��ؼ����Ŷ����ܾ�£���ĵ���ؼ����
 * @author Administrator
 *
 */
class TangShengPorxy implements QuJing{
	
	// ���ĵĹؼ����������������ӿڡ�
    private QuJing quJing;  
    
    public TangShengPorxy(){
    	this.quJing = new WuKong();//����������������µ�ʱ�����
    }
    
    public TangShengPorxy(QuJing quJing){ // ���԰� �˽� ɳɮ ����������
    	this.quJing = quJing;
    }
    
    //����Ĺ�������
	public void chuanJiao() {
		System.out.println("���������ڿ�");
		
	}
    //��� Σ�������
	public String huYan() {
		System.out.println(this.quJing.huYan());
		return this.quJing.huYan(); // �����������а�������������ǽӿ�
	}
    //������ �����
	public void shaGuai() {
		 this.quJing.shaGuai();  // �����������а�������������ǽӿ�
		
	}
}
