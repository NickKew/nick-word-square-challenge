package main.java.runner;

import java.util.ArrayList;
import java.util.List;

import main.java.calculator.MultiWordSquareCalculator;
import main.java.calculator.SingleWordSquareCalculator;
import main.java.models.GridSolution;
import main.java.utilities.SolutionOutput;

/**
 * Main application class for starting the word square search.
 */
public class WordSquareRunner 
{

	private static final List<GridSolution> VALID_SOLUTIONS = new ArrayList<>();
	
	public static void main(String[] args)
	{
		produceGridSquaresFor(args);
	}
	
	private static void produceGridSquaresFor(final String[] commandLineArguments)
	{	
		final int commandLineArgumentsSize = commandLineArguments.length;
		
		switch(commandLineArgumentsSize)
		{
			case 1:
				runOneCommandLineArgumentCase(commandLineArguments);
				break;
		
			case 2:
				runTwoCommandLineArgumentCase(commandLineArguments);	
				break;
				
			default:
				throw new IllegalArgumentException("Expected a grid size, and set of grid letters to fill in the grid.");
		}

		outputSolutions();
	}
	
	private static void outputSolutions()
	{
		SolutionOutput.outputSolutionsToConsole(VALID_SOLUTIONS);
	}
	
	private static void runOneCommandLineArgumentCase(final String[] commandLineArguments)
	{
		final String wordSquareTextFile = getWordSquareTextFile(commandLineArguments);
		
		VALID_SOLUTIONS.addAll(MultiWordSquareCalculator.computeMultipleGridSquareSolutions(wordSquareTextFile));
	}
	
	private static void runTwoCommandLineArgumentCase(final String[] commandLineArguments)
	{
		final int gridSize = getWordSquareGridSize(commandLineArguments); 
		final String lettersPopulatingGrid = getLettersPopulatingGrid(commandLineArguments);
		
		VALID_SOLUTIONS.addAll(SingleWordSquareCalculator.calculateValidWordSquares(gridSize, lettersPopulatingGrid));
	}
	
	private static int getWordSquareGridSize(final String[] commandLineArguments) {
		return Integer.parseInt(commandLineArguments[0]);
	}
	
	private static String getLettersPopulatingGrid(final String[] commandLineArguments) {
		return commandLineArguments[1];
	}
	
	private static String getWordSquareTextFile(final String[] commandLineArguments) {
		return commandLineArguments[0];
	}

}
