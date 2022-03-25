package weather;

public class CirrusCloud extends Cloud {
	CirrusCloud(float bottom, float top){
		super(bottom, top);
	}
	
	// Method overriding, Compile Time Polymorphism
	@Override
	String rain() {
		return "I cannot make rain";
	}
}
