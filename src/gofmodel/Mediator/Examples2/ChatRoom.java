package gofmodel.Mediator.Examples2;


public interface ChatRoom {
	
	//注册
	public void register(Member member);
	
	//发送文字
	public void sendText(String from,String to,String message);
	
	//发送图片
	public void sendImage(String from,String to,String message);
}
