package weather;
import java.util.ArrayList;

public class Sky2 extends ArrayList<Cloud>
{
	Sky2()
	{
		super(100);
	}
	
	public float getMeanHeight() 
	{
		float sum = 0;
		float i = 0;
		for (Cloud c : this ) {
			sum += c.getHeight();
			i ++;
		}
		return sum / i;
	}
	
	/**
	public boolean add(Cloud c) 
	{
		super.add(c);
		return true;
	}
	*/
	
	public static void main(String[] args)
	{
		Sky sky = new Sky();
		StratusCloud strat = new StratusCloud(100, 1000);
		CumulusCloud cum = new CumulusCloud(200, 1100);
		CirrusCloud cir = new CirrusCloud(150, 1050);
		Nimbus nim = new Nimbus(200);
		if (!strat.rain().startsWith("It is raining"))
			System.out.println("Bad StratusCloud::rain");
		sky.add(strat);
		sky.add(cir);
		sky.add(cum);
		
		float mean = sky.getMeanHeight();
		if (mean < 899  ||  mean > 901)
			System.out.println("Bad mean height: expected 900, saw " + mean);
		System.out.println("Everything (else) is ok");
	}
}
