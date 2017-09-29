package gofmodel.strategy;

public class Context {
	
	private Datebase datebase;
	
	public Context(Datebase datebase){
		
		this.datebase = datebase;
	}
	
	public void connectDBase(){
		datebase.connect();
	}

}
