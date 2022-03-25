package bubble;

public class BubbleSorter 
{
	private int[]		a;
	private long		nVisits;
	private long		nSwaps;
	
	
	public BubbleSorter(int[] a)
	{
		this.a = a; 
	}
	
	
	public void sort()
	{
		for (int i = a.length; i > 0 ; i--)
		{
			for (int j = a.length - 1; j > 0; j--)
			{
				// Increment number of visits by 2.
				nVisits = nVisits + 2;
				if (a[j] < a[j - 1])
				{
					// Swap the elements and increment nSwaps.
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
					nSwaps ++;
				}
			}
			
		}
	}
	
	
	public String toString()
	{
		String s = nVisits + " visits, " + nSwaps + " swaps\n{";
		for (int n: a)
			s += " " + n;
		s += " }";
		return s;
	}
	
	
	public boolean isSorted()
	{
		for (int i = 0; i < a.length - 2; i ++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	
	public long getNVisits()
	{
		return nVisits;
	}
	
	
	public long getNSwaps()
	{
		return nSwaps;
	}
	
	
	public int[] getArray()
	{
		return a;
	}
	
	
	public static void main(String[] args)
	{
		int[] a = BubbleSortTestCaseMaker.buildRandom(100, 1000);
		
		BubbleSorter sorter = new BubbleSorter(a);
		sorter.sort();
		System.out.println(sorter);
		System.out.println(sorter.isSorted()  ?  "SORTED"  :  "NOT SORTED");
	}
}
