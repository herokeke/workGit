package gofmodel.factory.AbstractFactory;
import org.junit.Test;
/**
 * ���󹤳�
 *      ��Ʒ�ṹ�����������쳧�� ���еĸ�������������ƣ� ��������Ķ������ͣ�
 *      ��Ʒ�أ�  ����������ɫ�� ������ɫ���Ժ󻹿�����ϸ����ֵ���ɫ������ƣ��Ķ�Ƶ��������������ӻ�ɾ����
 *      
 *      
 *      ���˼·��                 �ӿ�                                      �ӿڹ��� ��
 *                                                                        public �ӿ� get������A();
 *                                                                        public �ӿ� get������B();
 *                                                                         �� 
 *                  ������A                  ������B             ʵ�����ɫ�ع���       ʵ�����ɫ�ع���
 *          ʵ����A��ɫ�� ʵ����A��ɫ��   ʵ����B��ɫ�� ʵ����B��ɫ��
 * @author Administrator
 *
 */
public class AbstractFactoryTest {
	
	@Test
	public void testAbstractFactory(){
		FruitFactory cyanff = 	new CyanFactory();
		Fruit capple = cyanff.getApple();
		capple.eat();
		Fruit cbanana = cyanff.getBanana();
		cbanana.eat();
		
		FruitFactory yellosff = new YellowFactory();
		Fruit yapple = yellosff.getApple();
		yapple.eat();
		Fruit ybanana = yellosff.getBanana();
		ybanana.eat();
	}

}
