package weather;

public class Cloud {
	private float bottom;
	private float top;
	
	Cloud(float bottom, float top ){
		this.bottom = bottom;
		this.top = top;
	}
	
	float getHeight(){
		return top - bottom;
	}
	
	String rain() {
		return "It is raining";
	}
}
