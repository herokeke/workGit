package gofmodel.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * 遥控器
 * @author Administrator
 *
 */
public class Control {

	private List<Command> commandPool;
	
	public Control(){
		commandPool = new ArrayList<Command>();
	}
	
	
	public void turn(){
		for(Command  command : commandPool){
			command.execute();
		}
	}

	public void setCommand(Command command) {
		commandPool.add(command);
	}
	
	public void removeCommand(Command command){
		commandPool.remove(command);
	}
	
	
	
}
