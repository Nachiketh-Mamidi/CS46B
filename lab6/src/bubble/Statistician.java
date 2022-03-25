package bubble;

import java.util.*;


public class Statistician 
{
	private final static int N_REPETITIONS = 1000;
	
	private static void getStats(int arrayLength)
	{
		ArrayList<Long> visitCounts = new ArrayList<>();
		ArrayList<Long> swapCounts = new ArrayList<>();
		
		for (int i=0; i<N_REPETITIONS; i++)
		{
			int[] array = BubbleSortTestCaseMaker.buildRandom(arrayLength, arrayLength*100);
			BubbleSorter sorter = new BubbleSorter(array);
			sorter.sort();
			// Assert that the sorter sorted correctly.
			assert sorter.isSorted(): "not sorted";
			// Append # visits and # swaps to the array lists.
			visitCounts.add(sorter.getNVisits());
			swapCounts.add(sorter.getNSwaps());
		}
		long minVisits = visitCounts.get(0);
		long maxVisits = visitCounts.get(0);
		long avgVisits = 0;
		long sumVisits = 0;
		
		long minSwaps = swapCounts.get(0);
		long maxSwaps = swapCounts.get(0);
		long avgSwaps = 0;
		long sumSwaps = 0;
		
		for (long l : visitCounts) {
			if (l < minVisits) {
				minVisits = l;
			}
		}
		for (long l : visitCounts) {
			if (l > maxVisits) {
				maxVisits = l;
			}
		}
		for (long l : swapCounts) {
			if (l < minSwaps) {
				minSwaps = l;
			}
		}
		for (long l : swapCounts) {
			if (l > maxSwaps) {
				maxSwaps = l;
			}
		}
		
		for (long l : visitCounts) {
			sumVisits += l;
		}
		avgVisits = sumVisits / N_REPETITIONS;
		for (long l : swapCounts) {
			sumSwaps += l;
		}
		avgSwaps = sumSwaps / N_REPETITIONS;
		
		// Compute and print min/average/max number of visits.
		System.out.println("Minimum Visits: " + minVisits);
		System.out.println("Maximum Visits: " + maxVisits);
		System.out.println("Average Visits: " + avgVisits);
		// Compute and print min/average/max number of swaps.
		System.out.println("Minimum Swaps: " + minSwaps);
		System.out.println("Maximum Swaps: " + maxSwaps);
		System.out.println("Average Swaps: " + avgSwaps);
	}
	
	
	public static void main(String[] args)
	{
		System.out.println("1000:");
		getStats(1000);
		
		System.out.println("3000:");
		getStats(3000);
	}
}
