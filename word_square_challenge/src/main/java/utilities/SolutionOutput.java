package main.java.utilities;

import java.util.List;

import main.java.models.GridSolution;

public class SolutionOutput 
{	
	public static void outputSolutionsToConsole(final List<GridSolution> gridSolutions)
	{
		if(isAnyValidSolutions(gridSolutions))
		{
			outputSolutions(gridSolutions);
		}
		else
		{
			outputNoValidSolutionsToConsole();
		}
	}
		
	private static void outputSolutions(final List<GridSolution> validGridWordSolutions)
	{	
		for(final GridSolution validGridSolution: validGridWordSolutions)
		{	
			validGridSolution.outputSolutionToConsole();
		}
	}
		
	private static void outputNoValidSolutionsToConsole()
	{
		System.out.print("No Valid Grid Solution" + "\n");
	}
	
	private static boolean isAnyValidSolutions(final List<GridSolution> validGridWordSolutions)
	{
		return validGridWordSolutions.size() > 0;
	}
}
