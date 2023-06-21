package test.java.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.models.GridSolution;

public class ValidGridSolutionTest 
{
	private static final String VALID_SOLUTION_WORD = "word1";
	private static final int GRID_SIZE = 2;
	private static final String LETTERS_POPULATING_GRID = "oonn";
		
	@Test
	public void getValidSolutionWordsTest()
	{
		final List<String> validGridSolutionWords = createValidGridSolution();
		final GridSolution gridSolution = createGridSolutionFor(validGridSolutionWords);
		
		assertEquals(validGridSolutionWords, gridSolution.getValidSolutionWords());
	}
	
	@Test
	public void getNullSolutionWordsTest()
	{
		final List<String> nullGridSolutionWords = createNullGridSolution();
		final GridSolution gridSolution = createGridSolutionFor(nullGridSolutionWords);
		
		assertEquals(nullGridSolutionWords, gridSolution.getValidSolutionWords());
	}
	
	@Test
	public void toString_validWordSolutionTest()
	{
		final List<String> validGridSolutionWords = createValidGridSolution();
		final GridSolution gridSolution = createGridSolutionFor(validGridSolutionWords);
		
		assertCorrectToString(gridSolution.toString());
	}
	
	private void assertCorrectToString(final String gridSolutionString)
	{
		final String expectedString = VALID_SOLUTION_WORD + "\n";
		
		assertEquals(expectedString, gridSolutionString);
	}
	
	private GridSolution createGridSolutionFor(final List<String> gridSolutionWords)
	{
		return new GridSolution(gridSolutionWords, LETTERS_POPULATING_GRID, GRID_SIZE);
	}
	
	private List<String> createValidGridSolution()
	{
		return Arrays.asList(VALID_SOLUTION_WORD);
	}
	
	private List<String> createNullGridSolution()
	{
		return null;
	}
}
