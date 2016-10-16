package gofmodel.Mediator.Examples2;

import org.junit.Test;

/**
 * 中介者模式
 * Examples and analysis
 *       某论坛系统欲增加一个虚拟聊天室，允许论坛会员通过该聊天室进行信息交流。
 *       普通会员可以给其他会员发送文本信息。
 *       钻石会员既可以给其他会员发送文本信息，也可以发送图片信息。
 *       该聊天室可以对不雅字符进行过滤，还可以对发送的图片大小进行限制。
 *        
 * @author Administrator
 *
 */
public class MediatorTest {

    @Test
	public void testMediator(){
    	ChatRoom  chatRoom =  new ChatGroup();
    	
    	CommonMember cm1 = new CommonMember("大娃");
    	CommonMember cm2 = new CommonMember("二娃");
    	CommonMember cm3 = new CommonMember("三娃");
    	
    	DiamondMember dm1 = new DiamondMember("熊大");
    	DiamondMember dm2 = new DiamondMember("熊二");
    	
    	chatRoom.register(cm1);
    	chatRoom.register(cm2);
    	chatRoom.register(cm3);
    	chatRoom.register(dm1);
    	chatRoom.register(dm2);
    	
    	chatRoom.register(cm1);
    	chatRoom.register(cm2);
    	
    	cm1.sendText("二娃","二娃你好");
    	cm1.sendText("大娃", "自己发送信息");
    	dm1.sendImage("大娃","太阳");
    	dm2.sendImage("二娃","北斗七星都太阳");
    	cm3.sendText("熊二", "我们是社会主义民主国家");
    	
	}
	
}
