package main.java.calculator;


import java.util.List;

import main.java.handler.WordSquareDictionary;
import main.java.models.GridSolution;

/**
 * Class for calculating the possible solutions for a single word square.
 */
public class SingleWordSquareCalculator {
	
	private static int GRID_SIZE;
	private static String LETTERS_POPULATING_GRID;
	
	private static ValidGridComputer GRID_COMPUTER;
	
	/**
	 * Computes the Word Squares for the provided square parameters.
	 * 
	 * @param gridSize The size of the grid.
	 * @param lettersPopulatingGrid The letters to populate inside the grid.
	 * @return The list of valid grid solutions for the provided word square parameters.
	 */
	public static List<GridSolution> calculateValidWordSquares(final int gridSize, final String lettersPopulatingGrid)
	{
		setupGridSquareParameters(gridSize, lettersPopulatingGrid);
		
		final List<String> allValidWordsForGridSize = getAllValidWordsForGridSize();
		
		
		final List<String> validGridWords = getValidWordsForSquare(allValidWordsForGridSize);
		
		return getValidGridSolutionsFor(validGridWords);
	}
	
	private static void setupGridSquareParameters(final int gridSize, final String lettersPopulatingGrid)
	{
		GRID_SIZE = gridSize;
		LETTERS_POPULATING_GRID = lettersPopulatingGrid;
		
		createValidGridComputer(); 
	}
	
	private static List<String> getValidWordsForSquare(final List<String> allValidWordsForGridSize)
	{
		return ValidGridWordCalculator.getWordsValidForSquare(LETTERS_POPULATING_GRID, allValidWordsForGridSize);
	}
	
	private static List<String> getAllValidWordsForGridSize()
	{
		final WordSquareDictionary wordSquareDictionary = new WordSquareDictionary();
		return wordSquareDictionary.getValidWordsOfLength(GRID_SIZE);
	}
	
	
	private static List<GridSolution> getValidGridSolutionsFor(final List<String> validGridWords)
	{
		final List<GridSolution> validGridCombinations = GRID_COMPUTER.getValidWordSquareCombinations(validGridWords);
		
		return GRID_COMPUTER.getValidWordSquareSolutions(validGridCombinations);
	}
	
	private static void createValidGridComputer()
	{
		GRID_COMPUTER = new ValidGridComputer(LETTERS_POPULATING_GRID, GRID_SIZE);
	}
	
}
