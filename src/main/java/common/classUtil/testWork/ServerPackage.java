package common.classUtil.testWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.utils.StringUtils;

public class ServerPackage {
	
	private String currentno;
	private String previous;
	private int num;
	private String beginTime;
	private String endTime;
	private static int currentTime=10;
	
	private static Map<String,ServerPackage> mappool =  new HashMap<String,ServerPackage>();
	private static Map<String,String> mapList = new HashMap<String,String>();
	
	private static List<ServerPackage> list;
	
	static{
		list = new ArrayList<ServerPackage>();//      beginTime -- endTime
		list.add(new ServerPackage("10","",1));//         10     --    11
		list.add(new ServerPackage("20","",2));//         10     --    12
		list.add(new ServerPackage("30","10",3));//        11     --    14
		list.add(new ServerPackage("4","20,",4));//       12     --    16
		list.add(new ServerPackage("5","10,30",5));//      14     --    19
		list.add(new ServerPackage("6","20,4,5,10",6));//  19     --    25
		list.add(new ServerPackage("7","5,10",7));//      19     --    26
		list.add(new ServerPackage("8","10,6,7",8));//    26     --    34
		list.add(new ServerPackage("9","30,20,10",9));//  14     --    23
	}
	public ServerPackage(){}
	
	public ServerPackage(String currentno, String previous, int num) {
		super();
		this.currentno = currentno;
		this.previous = previous;
		this.num = num;
	}
	
	
	
	@Override
	public String toString() {
		return "[currentno=" + currentno + ", beginTime="
				+ beginTime + ", endTime=" + endTime + ", num=" + num
				+ ", previous=" + previous + "]";
	}
	

	public static void fun(List<ServerPackage> list){
		List<ServerPackage> funList = new ArrayList<ServerPackage>();
		if(list.size()==0)return;
		for(ServerPackage sp: list){
			for(String str: sp.previous.split("(?=[^\\d]),")){
				if("".equals(str)){
					sp.beginTime=String.valueOf(currentTime);
					sp.endTime = String.valueOf(currentTime+sp.num);
					mapList.put(sp.currentno,sp.endTime);
					mappool.put(sp.currentno,sp);
				}else if(mapList.containsKey(str)){
					int beginTime = Integer.parseInt(mapList.get(str));
					int endTime = Integer.parseInt(mapList.get(str))+sp.num;
					
					if(mapList.get(sp.currentno)==null || endTime>Integer.parseInt(mapList.get(sp.currentno))){
					//	sp.endTime = String.valueOf(endTime);
					//	sp.beginTime= String.valueOf(beginTime);
						mapList.put(sp.currentno,String.valueOf(endTime));
					}
					ServerPackage server = mappool.get(sp.currentno);
					if(server==null || beginTime>Integer.parseInt(server.beginTime)){
						sp.endTime = String.valueOf(endTime);
						sp.beginTime=String.valueOf(beginTime);
						mappool.put(sp.currentno,sp);
					}
				}else{
					funList.add(sp);
				}
					
			}
		 }
		 fun(funList);
		
	}


	

	public static void main(String[] args){
		
		fun(list);
		for(Map.Entry<String, ServerPackage> sp:mappool.entrySet()){
			System.out.println(sp.getValue().toString());
		}
		
		
		
	}

}
