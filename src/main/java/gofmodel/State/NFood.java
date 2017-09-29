package gofmodel.State;

/**
 * 晚餐
 * @author Administrator
 *
 */
public class NFood extends State {

	@Override
	public void handle(int hour) {
		 if(hour==18){
        	 System.out.println("晚餐");
         }else{
        	 new NFood().handle(hour);
         }
	}

}
