package gofmodel.Mediator.Examples2;

import java.util.Hashtable;

public class ChatGroup implements ChatRoom {
	
	private Hashtable members = new Hashtable();
	
	@Override
	public void register(Member member) {
		if(!members.contains(member)){
			members.put(member.name, member);
			member.setChatRoom(this);
		}
	}

	@Override
	public void sendImage(String from , String to, String message) {
		Member member = (Member) members.get(to);
		if(message.length()>5){
			System.out.println("长度过长无法发送");
		}else{
			member.receiveImage(from, message);
		}
		

	}

	@Override
	public void sendText(String from,String to, String message) {
		Member member = (Member) members.get(to);
		message = message.replaceAll("民主", "*"); //过滤文字
		member.receiveText(from, message);

	}

}
