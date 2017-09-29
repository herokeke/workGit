package gofmodel.State;

/**
 * 早餐
 * @author Administrator
 *
 */
public class MFood extends State {

	@Override
	public void handle(int hour) {
         if(hour==6){
        	 System.out.println("早餐");
         }else{
        	 new LFood().handle(hour);
         }
	}

}
