package gofmodel.Mediator.Examples2;

/**
 * 钻石会员
 * @author Administrator
 *
 */
public class DiamondMember extends Member {

	public DiamondMember(String name) {
		super(name);
	}

	@Override
	public void sendImage(String to, String message) {
		System.out.println("钻石会员发送图片信息：");
		this.getChatRoom().sendImage(name,to, message);
		
	}

	@Override
	public void sendText(String to, String message) {
		System.out.println("钻石会员发送信息：");
		this.getChatRoom().sendText(name,to, message);
		
	}

}
