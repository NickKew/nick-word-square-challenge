package test.java.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.utilities.Permutations;

public class PermutationsTest {

	@Test
	public void getAllPermutationsListTest()
	{
		final List<String> listToPermutate = Arrays.asList("1", "2", "3");
		
		final List<List<String>> permutatedList = Permutations.getAllPermutationsList(listToPermutate);
		
		assertPermutationsAsExpected(permutatedList);
	}
	
	@Test
	public void getAllPermutationsListTestForSize()
	{
		final List<String> listToPermutate = Arrays.asList("1", "2", "3");
		
		final List<List<String>> permutatedList = Permutations.getAllPermutationsListOfSize(listToPermutate, 2);
		
		assertPermutationsForSizeAsExpected(permutatedList);
	}
	
	
	private void assertPermutationsAsExpected(final List<List<String>> permutatedList)
	{
		assertEquals(6, permutatedList.size());
		
		assertTrue(permutatedList.contains(Arrays.asList("1", "2", "3")));
		assertTrue(permutatedList.contains(Arrays.asList("1", "3", "2")));
		assertTrue(permutatedList.contains(Arrays.asList("2", "1", "3")));
		assertTrue(permutatedList.contains(Arrays.asList("2", "3", "1")));
		assertTrue(permutatedList.contains(Arrays.asList("3", "1", "2")));
		assertTrue(permutatedList.contains(Arrays.asList("3", "2", "1")));
	}
	
	private void assertPermutationsForSizeAsExpected(final List<List<String>> permutatedList)
	{
		assertEquals(6, permutatedList.size());
		
		assertTrue(permutatedList.contains(Arrays.asList("1", "2")));
		assertTrue(permutatedList.contains(Arrays.asList("1", "3")));
		assertTrue(permutatedList.contains(Arrays.asList("2", "3")));
		assertTrue(permutatedList.contains(Arrays.asList("2", "1")));
		assertTrue(permutatedList.contains(Arrays.asList("3", "1")));
		assertTrue(permutatedList.contains(Arrays.asList("3", "2")));
	}
}
