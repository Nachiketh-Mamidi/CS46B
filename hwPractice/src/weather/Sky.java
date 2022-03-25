package weather;

import java.util.ArrayList;

public class Sky {
	ArrayList<Cloud> clouds;
	
	Sky(){
		clouds = new ArrayList<>(100);
	}
	
	 public boolean add(Cloud c) {
		clouds.add(c);
		return true;
	}
	
	float getMeanHeight() {
		float counter = 0;
		float sum = 0;
		for (Cloud c : clouds) {
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

