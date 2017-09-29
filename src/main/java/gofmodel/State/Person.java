package gofmodel.State;

public class Person {
	
	private State state;
	
	private int hour;

	public Person(){
		state = new MFood();
	}
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	//操作
    public void handle(){
    	state.handle(hour);
    }
}
