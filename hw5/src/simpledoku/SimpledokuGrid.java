package simpledoku;

import java.util.*;


public class SimpledokuGrid {

	private int				nCellsPerSide;
	private int[][]			values;
	
	
	public SimpledokuGrid(int nCellsPerSide)
	{
		this.nCellsPerSide = nCellsPerSide;
		values = new int[nCellsPerSide][nCellsPerSide];
	}
	
	
	// This is called a "copy constructor". A copy constructor has 1 argument, which is the same type as
	// the current class. The constructor should make the new instance look just like the "source"
	// instance. CAUTION: The source and the current grid should each have their own "values"
	// array. So don't say "this.values = source.values". You have to create a new values
	// array, and copy numbers from source.values into the new array, one at a time.
	public SimpledokuGrid(SimpledokuGrid source)
	{	
		this.nCellsPerSide = source.nCellsPerSide;
		this.values = new int[nCellsPerSide][nCellsPerSide];
		
		for (int i = 0; i < nCellsPerSide; i++) {
			for (int j = 0; j< nCellsPerSide; j ++) {
				values[i][j] = source.values[i][j];
			}
		}
	}	
	
	
	//
	// Returns true if the input list contains a repeated value that isn't zero.
	// Call this from isLegal(). DON’T CHANGE THIS METHOD, BUT UNDERSTAND HOW IT WORKS.
	//
	private boolean containsNonZeroRepeats(ArrayList<Integer> checkUs)
	{
		HashSet<Integer> set = new HashSet<>();
		for (Integer i: checkUs)
		{
			if (i != 0)
			{
				//could I write this a different way? DON'T CHANGE THE CODE, but THINK about it.
				
				if (set.contains(i))
					return true;
				else
					set.add(i);
			}
		}
		return false;
		
//		Collections.sort(checkUs);
//		checkUs.removeAll(Arrays.asList(0));
//		for (int i = 0; i < checkUs.size(); i ++) {
//			if (checkUs.get(i) == checkUs.get(i + 1)) {
//				return true;
//			}
//		}
//		return false;
		
//		Make a non zero treeset and compare if it has same elements has a non zero arraylist.
		
	}
	
	
	public boolean isLegal()
	{
		ArrayList<Integer> check = new ArrayList<Integer>();
		// Check all rows. For each row, put the corresponding numbers from
		// the "values" array into an ArrayList<Integer>. Then pass the array
		// list to containsNonZeroRepeats(). If containsNonZeroRepeats() return true,
		// then this grid isn't legal, so return false.
		
		for (int i = 0; i < this.values.length; i++)
		{
			for (int j = 0; j < this.values[i].length; j++)
				check.add(values[i][j]);
		
			if (this.containsNonZeroRepeats(check))
				return false;
			
			check.clear();
		}
		

		// Check all columns. For each column, put the corresponding numbers from
		// the "values" array into an ArrayList<Integer>. Then pass the array
		// list to containsNonZeroRepeats(). If containsNonZeroRepeats() return true,
		// then this grid isn't legal, so return false.
		for (int j = 0; j < this.values.length; j ++) {
			for (int i = 0; i < this.values.length; i ++) {
				check.add(values[i][j]);
			}
			if (this.containsNonZeroRepeats(check)) {
				return false;
			}
			check.clear();
		}
		

		
		// Check top-left to bottom-right diagonal. 
		for (int i = 0; i < this.values.length; i ++) {
			check.add(values[i][i]);
			}
		if (this.containsNonZeroRepeats(check)) {
			return false;
		}
		check.clear();
		
		// Check top-right to bottom-left diagonal. 
		for (int i = 0; i < values.length; i ++) {
			check.add(values[i][values.length - 1 - i]);
		}
		if (this.containsNonZeroRepeats(check)) {
			return false;
		}
		check.clear();
		
		// If we haven't returned yet, this grid must be legal.
		return true;
	}
	
	
	// Returns true if all members of the values[][] array are non-zero.
	public boolean isFull()
	{
		for (int i = 0; i < values.length;i ++) {
			for (int j = 0; j < values.length; j ++) {
				if (values[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}	
	
	
	
	// Returns the Evaluation corresponding to the state of this grid. The return will be
	// Evaluation.ABANDON, Evaluation.ACCEPT, or Evaluation.CONTINUE. Abandon if illegal,
	// accept if legal and the grid is full, continue if legal and incomplete.
	public Evaluation evaluate()
	{
		if (!isLegal())
			return Evaluation.ABANDON;
		else if (isFull())
			return Evaluation.ACCEPT;
		else
			return Evaluation.CONTINUE;
	}
	
	
	
	// Returns a size=2 array of ints that index the next empty cell in the values[][] array.
	// The 2 ints in the returned array are the first and second indices into the values[][] array.
	// Returns null if this grid is full.  DON’T CHANGE THIS METHOD, BUT UNDERSTAND HOW IT WORKS.
	private int[] getIndicesOfNextEmptyCell()
	{
		for (int x=0; x<nCellsPerSide; x++)
			for (int y=0; y<nCellsPerSide; y++)
				if (values[x][y] == 0)
					return new int[] {x, y};
		
		return null;
	}
	
	
	//
	// COMPLETE THIS
	//
	//
	// Finds an empty member of "values". Returns an array list containing nCellsPerSide grids that look 
	// like the current grid, except the empty member contains 1, 2, 3 .... nCellsPerSide. 
	// 
	//
	// Example: if this grid = 12300
	//                         00000
	//                         00000
	//                         00000
	//                         00000
	//
	// Then the returned array list contains:
	//
	//      12310        12320        12330        12340        12350
	//      00000        00000        00000        00000        00000
	//      00000        00000        00000        00000        00000
	//      00000        00000        00000        00000        00000
	//      00000        00000        00000        00000        00000
	//
	// To create each new grids, use the copy constructor and pass in "this" grid. Then
	// change one member of the "values" of the new grid.
	// CAUTION: Make sure you are generating new grids!
	ArrayList<SimpledokuGrid> generateAllNextGrids()
	{		
		int[] indicesOfNext = getIndicesOfNextEmptyCell();
		ArrayList<SimpledokuGrid> nextGrids = new ArrayList<SimpledokuGrid>();
		// Generate some grids and put them in nextGrids. Be sure that every
		// grid is a separate object.
		for (int i = 1; i <= this.nCellsPerSide; i ++) {
			SimpledokuGrid newGrid = new SimpledokuGrid(this);
			newGrid.values[indicesOfNext[0]][indicesOfNext[1]] = i;
			nextGrids.add(newGrid);
		}
		return nextGrids;
	}
	
	
	// Use this for debugging if it's helpful.  DON’T CHANGE THIS METHOD, BUT UNDERSTAND HOW IT WORKS.
	public String toString()
	{
		String s = "";
		for (int j=0; j<nCellsPerSide; j++)
		{
			for (int i=0; i<nCellsPerSide; i++)
			{
				if (values[j][i] == 0)
					s += ".";
				else
					s += ("" + values[j][i]);
			}
			s += "\n";
		}
		return s;
	}
	
	//You can add a main method here for debugging. 
	public static void main (String[] args) {
		SimpledokuGrid test = new SimpledokuGrid(4);
		test.values[0][0] = 1;
		test.values[0][1] = 1;
		test.values[0][2] = 3;
		System.out.println(test.getIndicesOfNextEmptyCell()[1]);
		System.out.println(test.generateAllNextGrids());
		System.out.println(test.evaluate());
		System.out.println(test.isFull());
		System.out.println(test.isLegal());
		
		
	}
}
