package test.java.calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.calculator.ValidGridWordCalculator;

public class ValidGridWordCalculatorTest 
{
	private static final String POTENTIAL_GRID_WORD_1 = "cat";
	private static final String POTENTIAL_GRID_WORD_2 = "mat";
	
	private static final String LETTERS_POPULATING_GRID = "catm";
	private static final String EMPTY_LETTERS_POPULATING_GRID = "";
	
	@Test
	public void getValidWordsForSquare_emptyLettersPopulatingGridTest()
	{
		final String emptyLettersPopulatingGrid = createEmptyLettersPopulatingGrid();
		final List<String> potentialGridWords = createPotentialGridWords();
		
		final List<String> validWordsForSquare = getValidWordsFor(emptyLettersPopulatingGrid, potentialGridWords);
		
		assertTrue(validWordsForSquare.isEmpty());
	}
	
	@Test
	public void getValidWordsForSquare_noPotentialWordsTest()
	{
		final String emptyLettersPopulatingGrid = createLettersPopulatingGrid();
		final List<String> potentialGridWords = createEmptyPotentialGridWords();
		
		final List<String> validWordsForSquare = getValidWordsFor(emptyLettersPopulatingGrid, potentialGridWords);
		
		assertTrue(validWordsForSquare.isEmpty());
	}
	
	@Test
	public void getValidWordsForSquare_validWordsTest()
	{
		final String emptyLettersPopulatingGrid = createLettersPopulatingGrid();
		final List<String> potentialGridWords = createPotentialGridWords();
		
		final List<String> validWordsForSquare = getValidWordsFor(emptyLettersPopulatingGrid, potentialGridWords);
		
		assertTrue(!validWordsForSquare.isEmpty());
		assertValidWordsAsExpected(validWordsForSquare);
	}
	
	private List<String> getValidWordsFor(final String lettersPopulatingGrid, final List<String> potentialGridWords)
	{
		return ValidGridWordCalculator.getWordsValidForSquare(lettersPopulatingGrid, potentialGridWords);
	}
	
	private List<String> createPotentialGridWords()
	{
		return Arrays.asList(POTENTIAL_GRID_WORD_1, POTENTIAL_GRID_WORD_2);
	}
	
	private void assertValidWordsAsExpected(final List<String> validSquareWords)
	{
		assertTrue(validSquareWords.contains(POTENTIAL_GRID_WORD_1));
		assertTrue(validSquareWords.contains(POTENTIAL_GRID_WORD_2));
	}
	
	private List<String> createEmptyPotentialGridWords()
	{
		return Arrays.asList();
	}
	
	private String createEmptyLettersPopulatingGrid()
	{
		return EMPTY_LETTERS_POPULATING_GRID;
	}
	
	private String createLettersPopulatingGrid()
	{
		return LETTERS_POPULATING_GRID;
	}
}
