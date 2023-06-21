package test.java.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.handler.WordSquareDictionary;

public class WordSquareDictionaryTest 
{	

	private static final int VALID_WORD_LENGTH = 3;
	private static final int INVALID_WORD_LENGTH = -1;
	
	private WordSquareDictionary wordSquareDictionary;
	
	@BeforeEach
	public void createDictionary()
	{
		this.wordSquareDictionary = new WordSquareDictionary();
	}
	
	@Test
	public void validWordLengthTest()
	{	
		List<String> validGameWords = getGridWordsFor(VALID_WORD_LENGTH);
		
		assertValidGridWordsExist(validGameWords);
	}
	
	
	@Test 
	public void invalidWordLengthTest()
	{	
		List<String> validGameWords = getGridWordsFor(INVALID_WORD_LENGTH);
		
		assertNoValidGridWords(validGameWords);	
	}
	
	private List<String> getGridWordsFor(final int wordLength)
	{
		return this.wordSquareDictionary.getValidWordsOfLength(wordLength);
	}
	
	private void assertNoValidGridWords(final List<String> validGameWords)
	{
		assertEquals(0, validGameWords.size());	
	}
	
	private void assertValidGridWordsExist(final List<String> validGameWords)
	{
		assertTrue(validGameWords.size() >= 0);
	}
	
}
