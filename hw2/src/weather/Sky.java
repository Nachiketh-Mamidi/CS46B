package weather;
import java.util.ArrayList;

public class Sky 
{
	private ArrayList<Cloud> clouds;
	Sky()
	{
		clouds = new ArrayList<>(100);
	}
	
	public boolean add(Cloud c) 
	{
		clouds.add(c);
		return true;
	}
	
	public float getMeanHeight() 
	{
		float sum = 0;
		float i = 0;
		for (Cloud c : clouds) {
			sum += c.getHeight();
			i ++;
		}
		return sum / i;
	}
	
	public static void main(String[] args)
	{
		Sky sky = new Sky();
		StratusCloud strat = new StratusCloud(100, 1000);
		CumulusCloud cum = new CumulusCloud(200, 1100);
		CirrusCloud cir = new CirrusCloud(150, 1050);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		sky.add(strat);
		sky.add(cum);
		sky.add(cir);
		
		float mean = sky.getMeanHeight();
		if (mean < 899  ||  mean > 901)
			System.out.println("Bad mean height: expected 900, saw " + mean);
		System.out.println("Everything (else) is ok");
	}

	
}
