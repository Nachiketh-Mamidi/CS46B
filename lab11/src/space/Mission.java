package space;

import java.util.ArrayList;


public class Mission implements Comparable<Mission>
{
	private String			destination;
	private float			cost;
	
	
	public Mission(String destination, Float cost)
	{
		this.destination = destination;
		this.cost = cost;
	}
	
	
	public String getDestination()
	{
		return destination;
	}
	
	
	public float getCost()
	{
		return cost;
	}


	// Compare by cost, then by destination.
	public int compareTo(Mission that) 
	{ 		
		if (this.cost == that.cost) {
			return this.destination.compareTo(that.destination);
		} else {
			if (this.cost < that.cost) {
				return -1;
			} else {
				return 1;
			}
		}

	}
	
	
	// Let compareTo() do the work. This method should just be 1 line.
	public boolean equals(Object x)
	{
		Mission s = (Mission) x;
		return this.compareTo(s) == 0;
	}
	
	
	// Return the destination’s hash code.
	public int hashCode()
	{
		return (int)this.cost + this.destination.hashCode();
		
		
	}
	
	
	public String toString()
	{
		return "Mission to " + destination + " will cost " + cost;
	}
	
	public static void main(String[] args) {
		Mission m1 = new Mission("test", 100f);
		Mission m2 = new Mission("test", 100f);
		
		Mission m3 = new Mission("test2", 200f);
		Mission m4 = new Mission("test3", 200f);
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.compareTo(m2));
		System.out.println(m3.compareTo(m4));
	}
}

