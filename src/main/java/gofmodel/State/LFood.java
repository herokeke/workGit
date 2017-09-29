package gofmodel.State;

/**
 * 中餐
 * @author Administrator
 *
 */
public class LFood extends State {

	@Override
	public void handle(int hour) {
		 if(hour==12){
        	 System.out.println("中餐");
         }else{
        	 new NFood().handle(hour);
         }

	}

}
