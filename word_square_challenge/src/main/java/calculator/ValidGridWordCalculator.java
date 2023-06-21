package main.java.calculator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Object to store the potential words in the grid given for the provided 
 */
public class ValidGridWordCalculator
{
	private static Map<String, Long> SQUARE_LETTER_COUTNER = null;
	
	/**
	 * Gets all of the words that can be used within the word square.
	 * 
	 * @param lettersPopulatingGrid The list of letters to populate the grid with.
	 * @param potentialGridWords The list of words as wide/tall as the grid.
	 * @return Potential words that can be contained in the square given the grid letters.
	 */
	public static List<String> getWordsValidForSquare(final String lettersPopulatingGrid, final List<String> potentialGridWords)
	{				
		List<String> validGridWords = new ArrayList<>();
		
		produceGridLetterCounter(lettersPopulatingGrid);
		
		for(String potentialGridWord : potentialGridWords)
		{
			boolean gridWordValid = isGridWordValid(potentialGridWord);			
			
			if(gridWordValid == true)
			{
				validGridWords.add(potentialGridWord);
			}
			
		}
		
		SQUARE_LETTER_COUTNER = null;
		
		return validGridWords;
	}
	
	private static void produceGridLetterCounter(final String lettersPopulatingGrid)
	{
		SQUARE_LETTER_COUTNER = producePotentialGridWordLetterCounter(lettersPopulatingGrid);
	}
	
	private static boolean isGridWordValid(String potentialGameWord) 
	{
		Map<String, Long> potentialGameWordLetterCounter = producePotentialGridWordLetterCounter(potentialGameWord);
		
		boolean isGameWordValid = true;
		
		for(Map.Entry<String, Long> potentialGameWordLetterEntry: potentialGameWordLetterCounter.entrySet())
		{
			final String potentialGameWordLetter = potentialGameWordLetterEntry.getKey();
			final Long potentialGameWordLetterCount = potentialGameWordLetterEntry.getValue();
			
			if(isWordValidOnSquare(potentialGameWordLetter, potentialGameWordLetterCount))
			{
				isGameWordValid = false;
				break;
			}
		}
		
		return isGameWordValid;
	}
	
	private static boolean isWordValidOnSquare(final String potentialGameWordLetter, final Long potentialGameWordLetterCounter)
	{
		return isLetterPossibleInSquare(potentialGameWordLetter)||  
				isSufficientNumberOfLetters(potentialGameWordLetter, potentialGameWordLetterCounter);
	}
	
	private static boolean isLetterPossibleInSquare(final String potentialGameWordLetter)
	{
		return !SQUARE_LETTER_COUTNER.containsKey(potentialGameWordLetter);
	}
	
	private static boolean isSufficientNumberOfLetters(final String potentialGameWordLetter, final Long potentialGameWordLetterCounter)
	{
		return SQUARE_LETTER_COUTNER.get(potentialGameWordLetter) < potentialGameWordLetterCounter;
	}
	
	private static Map<String, Long> producePotentialGridWordLetterCounter(String word)
	{
		return word.chars()
				  .mapToObj(s -> Character.toLowerCase((char) s))
				  .collect(Collectors.groupingBy(s -> s.toString(), LinkedHashMap::new, Collectors.counting()));
	}
	
	
}
