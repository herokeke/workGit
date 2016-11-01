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
 *        定义：用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式的相互引用，从而使其耦合松散，而且可以独立的改变他们之间的交互。
 *        说明：引用一个中间对象，使系统中原有对象两两之间的复杂交互关系简化为与中间对象的交互，将一个网状结构重构为一个星形结构。
 *        频率：2
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
