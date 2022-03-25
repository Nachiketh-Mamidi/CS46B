package weather;

import java.util.ArrayList;

public class Sky2 extends ArrayList<Cloud> {
	Sky2(){
		super(100);
	}
	
	float getMeanHeight() {
		float counter = 0;
		float sum = 0;
		for (Cloud c : this) {
			if(c != null) 
				counter ++;
			sum += c.getHeight();
		}
		return sum / counter;
	}
	
	public static void main(String[] args)
	{
		Sky sky = new Sky();
		
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		sky.add(strat);
		
		float mean = sky.getMeanHeight();
		if (mean < 899  ||  mean > 901)
			System.out.println("Bad mean height: expected 900, saw " + mean);
		System.out.println("Everything (else) is ok");
	}
}
