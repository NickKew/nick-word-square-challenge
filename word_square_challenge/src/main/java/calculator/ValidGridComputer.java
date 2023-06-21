package main.java.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import main.java.models.GridSolution;
import main.java.utilities.Permutations;
import main.java.utilities.WordSquareCombinationIterator;

public class ValidGridComputer 
{
	private char[] lettersPopulatingGrid;
	private int gridSize;
	private String lettersInGrid;
	
	private List<GridSolution> validWordCombinationsForGrid = new ArrayList<>();
	
	public ValidGridComputer(String gameString, int gridSize)
	{
		this.lettersPopulatingGrid = gameString.toCharArray();
		Arrays.sort(this.lettersPopulatingGrid);
		
		this.gridSize = gridSize;
		this.lettersInGrid = gameString;
	}
	
	/**
	 * Gets all of the valid combinations of words that an be contained in the word square.
	 * 
	 * @param validWords The list of all valid words that can be contained in the word square.
	 * @return The list of all potential Valid Grid Solution Combinations.
	 */
	public List<GridSolution> getValidWordSquareCombinations(List<String> validWords)
	{
		if(existsValidWords(validWords))
		{
			computeValidWordSquareCombinations(validWords);
		}
		
		return this.validWordCombinationsForGrid;
	}
	
	/**
	 * Gets all of the valid word square combinations for the list of potential valid word squares.
	 * 
	 * @param validGridSquareCombinations The list of valid grid square combinations to check for valid solutions.
	 * @return The list of all valid word square combinations.
	 */
	public List<GridSolution> getValidWordSquareSolutions(List<GridSolution> validGridSquareCombinations)
	{		
		final List<GridSolution> validGridSolutions = new ArrayList<>();
		
		for(GridSolution possibleSolution : validGridSquareCombinations)
		{
			wordCombinationValidOntoSquare(possibleSolution.getValidSolutionWords(), validGridSolutions);
		}
		
		return validGridSolutions;
	}
	
	private void computeValidWordSquareCombinations(final List<String> validWords)
	{
		WordSquareCombinationIterator combinationIterator = new WordSquareCombinationIterator(validWords, gridSize);
		
		while(combinationIterator.hasNext())
		{
			List<String> potentialWordSolution = combinationIterator.next();
			
			isWordCombinationValidForLettersInGrid(potentialWordSolution);
		}
	}
	
	private boolean existsValidWords(final List<String> validWords)
	{
		return !validWords.isEmpty();
	}
	
	private void wordCombinationValidOntoSquare(final List<String> validGridSquareCombination, final List<GridSolution> validGridSolutions)
	{		
		for(List<String> gridSquarePermutaion : Permutations.getAllPermutationsList(validGridSquareCombination)) 
		{
			processWordSquarePermutaion(gridSquarePermutaion, validGridSolutions);
		}
	}
	
	private void processWordSquarePermutaion(final List<String> gridSquarePermutation, final List<GridSolution> validGridSolutions)
	{
		String[] wordSquareRows = computeWordSquareRows(gridSquarePermutation);
		
		String[] wordSquareColumns = computeWordSquareColumns(wordSquareRows);
			
		if(wordRowsAndColumnsAreEqual(wordSquareRows, wordSquareColumns))
		{
			validGridSolutions.add(produceValidGridSolution(gridSquarePermutation));
		}
	}
	
	private GridSolution produceValidGridSolution(final List<String> gridSquarePermutation)
	{
		return new GridSolution(gridSquarePermutation, this.lettersInGrid, this.gridSize);
	}
	
	private boolean wordRowsAndColumnsAreEqual(final String[] wordRows, final String[] wordColumns)
	{
		return Arrays.equals(wordRows, wordColumns);
	}
	
	private String[] computeWordSquareRows(final List<String> gridSquarePermutaion)
	{
		return gridSquarePermutaion.toArray(String[]::new);
	}
	
	private String[] computeWordSquareColumns(final String[] wordRows)
	{
		String[] wordColumns = new String[wordRows.length];
		
		for(int i = 0; i < wordRows.length; i++)
		{
			String word = wordRows[i];
				
			for(int j = 0; j < word.length(); j++)
			{
				String existingWordColumn = (wordColumns[j] == null) ? "" : wordColumns[j];
					
				wordColumns[j] = existingWordColumn + word.charAt(j);				
			}
		}
		
		return wordColumns;
	}
	
	private void isWordCombinationValidForLettersInGrid(List<String> potentialWordSquareCombination)
	{
		char[] potentialSolutionCharArray = getPotentialWordSquareCharArray(potentialWordSquareCombination);
			
		if(potentialSolutionCharArrayEqualsLettersPopulatingGrid(potentialSolutionCharArray))
		{
			addWordSquareCombinationToSolutionList(potentialWordSquareCombination);
		}
	}
	
	private void addWordSquareCombinationToSolutionList(final List<String> validWordSquareCombination)
	{
		GridSolution solution = new GridSolution(validWordSquareCombination, this.lettersInGrid, this.gridSize);
		
		this.validWordCombinationsForGrid.add(solution);
	}
	
	private boolean potentialSolutionCharArrayEqualsLettersPopulatingGrid(final char[] potentialSolutionCharArray)
	{
		return Arrays.equals(potentialSolutionCharArray, lettersPopulatingGrid);
	}
	
	private char[] getPotentialWordSquareCharArray(final List<String> potentialWordSquareCombination)
	{
		char[] potentialWordSquareCharArray = String.join("", potentialWordSquareCombination).toCharArray();
		Arrays.sort(potentialWordSquareCharArray);
		
		return potentialWordSquareCharArray;
	}
}
