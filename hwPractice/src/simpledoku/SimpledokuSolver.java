package simpledoku;

import java.util.*;


public class SimpledokuSolver 
{
	private int							nCellsPerSide;
	private SimpledokuGrid				solution;
	
	
	public SimpledokuSolver(int nCellsPerSide) throws IllegalArgumentException 
	{
		if (nCellsPerSide < 1) {
			throw new IllegalArgumentException();
		}
		this.nCellsPerSide = nCellsPerSide;
	}
	
	
	public void solve()
	{
		SimpledokuGrid emptyGrid = new SimpledokuGrid(nCellsPerSide);
		solveRecurse(emptyGrid);
	}
		
	
	private void solveRecurse(SimpledokuGrid theCurrentGrid)
	{		
		// Just return if a solution has been found.
		if (solution != null)
			return;
		
		// Evaluate the current grid.
		Evaluation eval = theCurrentGrid.evaluate();
		
		if (eval == Evaluation.ABANDON)
		{
			// To abandon the current grid, just return.
			return;
		}
		else if (eval == Evaluation.ACCEPT)
		{
			// Set solution to be the current grid.
			solution = theCurrentGrid;
		}
		else
		{
			// Generate all possible next grids, and call solveRecurse on them.
			for (SimpledokuGrid nextGrid: theCurrentGrid.generateAllNextGrids())
				solveRecurse(nextGrid);
		}
	}

	
	public SimpledokuGrid getSolution()
	{
		return solution;
	}
	
	
	public static void main(String[] args)
	{
		SimpledokuSolver solver = new SimpledokuSolver(4);
		solver.solve();
		System.out.println("SOLUTION:\n" + solver.getSolution());
	}
}
