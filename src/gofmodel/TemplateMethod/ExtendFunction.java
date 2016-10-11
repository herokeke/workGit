package gofmodel.TemplateMethod;

public abstract class ExtendFunction {

	public abstract void beginOpen();
	public abstract void commitPhase1();
	public abstract void commitPhase2();
	public abstract void commitPhase3();
	public abstract void endOpen();
	
	public void process(){
		
		beginOpen();
		commitPhase1();
		commitPhase2();
		commitPhase3();
		endOpen();
		
	}
}
