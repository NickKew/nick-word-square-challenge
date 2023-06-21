package test.java.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import main.java.calculator.SingleWordSquareCalculator;
import main.java.calculator.ValidGridComputer;
import main.java.models.GridSolution;

@TestInstance(Lifecycle.PER_CLASS)
public class SingleWordCalculatorTest 
{	
	@Test
	public void calculateWordSquares_noGridLetterTest()
	{
		List<GridSolution> gridSolutions = SingleWordSquareCalculator.calculateValidWordSquares(2,  "");
		
		assertEquals(0, gridSolutions.size());
		
	}
	
	@Test
	public void calculateWordSquares_invalidGridSizeTest()
	{
		List<GridSolution> gridSolutions = SingleWordSquareCalculator.calculateValidWordSquares(-1,  "cat");
		
		assertEquals(0, gridSolutions.size());	
	}
	
	@Test
	public void calculateWordSquares_multiValidSquareTest()
	{
		List<GridSolution> gridSolutions = SingleWordSquareCalculator.calculateValidWordSquares(2, "oonn");
		
		assertEquals(2, gridSolutions.size());
	}
	
	@Test
	public void calculateWordSquares_singleValidSquareTest()
	{
		List<GridSolution> gridSolutions = SingleWordSquareCalculator.calculateValidWordSquares(4, "eeeeddoonnnsssrv");
		
		assertEquals(1, gridSolutions.size());
		
		assertSolutionWordsAsExpected(gridSolutions.get(0));
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
