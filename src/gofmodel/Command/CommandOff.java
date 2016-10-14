package gofmodel.Command;

/**
 * 
 * @author Administrator
 *
 */
public class CommandOff implements Command {

	private Television television;
	
	public CommandOff(Television television){
		this.television = television;
	}
	
	@Override
	public void execute() {
		television.turnOff();
	}

}
