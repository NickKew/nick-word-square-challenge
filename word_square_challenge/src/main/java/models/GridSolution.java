package main.java.models;

import java.util.List;

/**
 * Data-structure to store a Grid Solution.
 */
public class GridSolution
{
	private final List<String> validGridSolutionWords;
	
	private final String lettersPopulatingGrid;
	
	private final int gridSize;

	public GridSolution(final List<String> validGridSolutionWords, final String lettersPopulatingGrid, final int gridSize)
	{
		this.validGridSolutionWords = validGridSolutionWords;
		this.lettersPopulatingGrid = lettersPopulatingGrid;
		this.gridSize = gridSize;
	}
	
	public List<String> getValidSolutionWords() {
		return validGridSolutionWords;
	}
	
	public void outputSolutionToConsole()
	{
		System.out.print("Valid Grid Solution for: " + gridSize + " " + lettersPopulatingGrid + "\n");
		
		System.out.print(toString());
	}
	
	public String toString()
	{
		String solutionString = "";
		
		for(final String validGridSolutionWord : validGridSolutionWords)
		{
			solutionString += validGridSolutionWord + "\n";
		}
		
		return solutionString;
	}
}
