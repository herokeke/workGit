package gofmodel.Command;

/**
 * 
 * @author Administrator
 *
 */
public class CommandOn implements Command {

    private Television television;
	
	public CommandOn(Television television){
		this.television = television;
	}
	
	@Override
	public void execute() {
		television.turnOn();
	}

}

