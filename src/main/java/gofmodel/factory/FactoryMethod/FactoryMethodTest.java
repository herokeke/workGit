package gofmodel.factory.FactoryMethod;

import org.junit.Test;

/**
 * ��������
 *     ��������ģʽͬ��������Ĵ�����ģʽ�ֱ���Ϊ��̬����ģʽ 
 *     �ܺõķ����ˡ����ţ���ա�ԭ��
 *     ��������ģʽ�˻�������ݱ�ɼ򵥹���ģʽ�� 
 *     
 *     ���˼·��     �ӿ�            �ӿڹ��� 
 *             ʵ����A ʵ����B    ʵ����A���� ʵ����B����
 *     
 * @author Administrator
 *
 */
public class FactoryMethodTest {

	@Test
	public void TestFactoryMethod(){
		FruitFactory fapple = new AppleFactory();
		Fruit apple = fapple.getFruit();
		apple.eat();
		FruitFactory fbanana = new BananaFactory();
		Fruit banana = fbanana.getFruit();
		banana.eat();
	}
}
