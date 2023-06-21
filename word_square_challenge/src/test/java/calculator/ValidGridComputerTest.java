package test.java.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.calculator.ValidGridComputer;
import main.java.models.GridSolution;

public class ValidGridComputerTest 
{
	
	private static final String VALID_GRID_WORD_1 = "cat";
	private static final String VALID_GRID_WORD_2 = "mat";
	
	private static final String LETTERS_POPULATING_GRID_1 = "catmat";
	private static final String LETTERS_POPULATING_GRID_2 = "eeeeddoonnnsssrv";
	private static final String EMPTY_LETTERS_POPULATING_GRID = "";
	
	private static final int VALID_GRID_SIZE = 2;
	private static final int INVALID_GRID_SIZE = -1;
	
	@Test
	public void getValidWordCombinations_noValidWordsTest()
	{
		final List<String> noValidWords = noValidWordsList();
		
		final ValidGridComputer gridComputer = new ValidGridComputer(LETTERS_POPULATING_GRID_1, VALID_GRID_SIZE);
		
		final List<GridSolution> gridSolutions = gridComputer.getValidWordSquareCombinations(noValidWords);
		
		assertTrue(gridSolutions.isEmpty());
	}
	
	@Test
	public void getValidWordCombinations_validWordsTest()
	{
		final List<String> validWords = createValidGridWords();
		
		final ValidGridComputer gridComputer = new ValidGridComputer(LETTERS_POPULATING_GRID_1, VALID_GRID_SIZE);
		
		final List<GridSolution> gridSolutions = gridComputer.getValidWordSquareCombinations(validWords);
		
		assertTrue(!gridSolutions.isEmpty());
	}
	
	@Test
	public void getValidWordSolution_noValidGridSquareTest()
	{
		final List<GridSolution> emptyGridSolution = noValidGridCombinationsList();
		
		final ValidGridComputer gridComputer = new ValidGridComputer(LETTERS_POPULATING_GRID_2, VALID_GRID_SIZE);
		
		final List<GridSolution> gridSolutions = gridComputer.getValidWordSquareSolutions(emptyGridSolution);
		
		assertTrue(gridSolutions.isEmpty());
	}
	
	@Test
	public void getValidWordSolution_validGridSquareTest()
	{
		final List<GridSolution> validGridSolution = Arrays.asList(createValidGridSolution());
		
		final ValidGridComputer gridComputer = new ValidGridComputer(LETTERS_POPULATING_GRID_2, VALID_GRID_SIZE);
		
		final List<GridSolution> gridSolutions = gridComputer.getValidWordSquareSolutions(validGridSolution);
		
		assertTrue(!gridSolutions.isEmpty());
		
		assertSolutionWordsAsExpected(gridSolutions.get(0));
	}
	
	@Test
	public void getValidWordSolution_invalidGridSquareTest()
	{
		final List<GridSolution> invalidGridSolution = Arrays.asList(createInvalidGridSolution());
		
		final ValidGridComputer gridComputer = new ValidGridComputer(EMPTY_LETTERS_POPULATING_GRID, VALID_GRID_SIZE);
		
		final List<GridSolution> gridSolutions = gridComputer.getValidWordSquareSolutions(invalidGridSolution);
		
		assertTrue(gridSolutions.isEmpty());
	}
	
	private void assertSolutionWordsAsExpected(final GridSolution gridSolution)
	{
		final List<String> solutionWords = gridSolution.getValidSolutionWords();
		
		assertEquals("rose", solutionWords.get(0));
		assertEquals("oven", solutionWords.get(1));
		assertEquals("send", solutionWords.get(2));
		assertEquals("ends", solutionWords.get(3));
	}
	
	public GridSolution createInvalidGridSolution()
	{
		final List<String> wordsPopulatingGrid = createInvalidWordsPopulatingGridList();
		
		return new GridSolution(wordsPopulatingGrid, EMPTY_LETTERS_POPULATING_GRID, 4);
	}
	
	public GridSolution createValidGridSolution()
	{
		final List<String> wordsPopulatingGrid = createWordsPopulatingGridList();
		
		return new GridSolution(wordsPopulatingGrid, LETTERS_POPULATING_GRID_2, 4);
	}
	
	private List<String> createWordsPopulatingGridList()
	{
		return Arrays.asList("oven", "rose", "send", "ends");
	}
	
	private List<String> createInvalidWordsPopulatingGridList()
	{
		return Arrays.asList("oven", "nove", "seed", "ends");
	}
	
	private List<GridSolution> noValidGridCombinationsList()
	{
		return Arrays.asList();
	}
	
	private List<String> noValidWordsList()
	{
		return Arrays.asList();
	}
	
	private String createEmptyLettersPopulatingGrid()
	{
		return EMPTY_LETTERS_POPULATING_GRID;
	}
	
	private String createLettersPopulatingGrid()
	{
		return LETTERS_POPULATING_GRID_1;
	}
	
	private List<String> createValidGridWords()
	{
		return Arrays.asList(VALID_GRID_WORD_1, VALID_GRID_WORD_2);
	}
}
