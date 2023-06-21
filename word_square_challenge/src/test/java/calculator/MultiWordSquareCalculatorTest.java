package test.java.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.calculator.MultiWordSquareCalculator;
import main.java.models.GridSolution;

public class MultiWordSquareCalculatorTest 
{
	private static final String VALID_SOLUTION_FILE_NAME = "validSolution.txt";
	private static final String INVALID_GRID_SIZE_FILE_NAME = "validSolution.txt";
	private static final String INVALID_CHAR_LENGTH_FILE_NAME = "validSolution.txt";
	
	@Test
	public void getValidSolution_invalidCharLengthTest()
	{
		final String path = getInvalidCharLengthFilePath();
		
		final List<GridSolution> gridSolutions = getValidSolutionFor(path);
		
		verifyNoSolutions(gridSolutions);
	}
	
	@Test
	public void getValidSolution_invalidGridSizeTest()
	{
		final String path = getInvalidGridSizeFilePath();
		
		final List<GridSolution> gridSolutions = getValidSolutionFor(path);
		
		verifyNoSolutions(gridSolutions);
	}
	
	@Test
	public void getValidSolution_validSolutionTest()
	{
		final String path = getValidSolutionFilePath();
		
		final List<GridSolution> gridSolutions = getValidSolutionFor(path);
		
		assertEquals(1, gridSolutions.size());
		
		assertSolutionWordsAsExpected(gridSolutions.get(0));
	}
	
	private String getValidSolutionFilePath()
	{
		return ClassLoader.getSystemClassLoader().getResource(VALID_SOLUTION_FILE_NAME).getPath();
	}
	
	private String getInvalidCharLengthFilePath()
	{
		return ClassLoader.getSystemClassLoader().getResource(INVALID_CHAR_LENGTH_FILE_NAME).getPath();
	}
	
	private String getInvalidGridSizeFilePath()
	{
		return ClassLoader.getSystemClassLoader().getResource(INVALID_GRID_SIZE_FILE_NAME).getPath();
	}
	
	private List<GridSolution> getValidSolutionFor(final String filePath)
	{
		return MultiWordSquareCalculator.computeMultipleGridSquareSolutions(filePath);
	}
	
	private void verifyNoSolutions(final List<GridSolution> gridSolutions)
	{
		assertEquals(0, gridSolutions.size()); 
	}
	
	private void assertSolutionWordsAsExpected(final GridSolution gridSolution)
	{
		final List<String> solutionWords = gridSolution.getValidSolutionWords();
		
		assertEquals("rose", solutionWords.get(0));
		assertEquals("oven", solutionWords.get(1));
		assertEquals("send", solutionWords.get(2));
		assertEquals("ends", solutionWords.get(3));
	}
}
