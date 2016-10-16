package gofmodel.Mediator.Examples2;

/**
 * 普通会员
 * @author Administrator
 *
 */
public class CommonMember extends Member {

	public CommonMember(String name) {
		super(name);
	}


	@Override
	public void sendImage(String to, String message) {
		System.out.println("普通会员不能发送图片信息：");
	//	this.getChatRoom().sendImage(to, message);
		
	}

	@Override
	public void sendText(String to, String messgae) {
		System.out.println("普通会员发送信息： ");
		this.getChatRoom().sendText(name,to, messgae);
		
	}

	
}
