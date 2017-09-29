package gofmodel.Bridge.bridge;

public abstract class Drawing {
	
    private Color color;  //行为的引用 很重要
    
	public Drawing(Color color){ //构造方法传入。 或者用getter setter
    	this.color = color;
    }
    
	public abstract void draw(); 
	
	//-----------getter setter----------------
	public Color getColor() {
			return color;
	}

	public void setColor(Color color) {
			this.color = color;
	}
}
