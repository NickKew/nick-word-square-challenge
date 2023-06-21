package main.java.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Store all of the words that are valid within the word square. 
 */
public class WordSquareDictionary {

	private final static String DICTIONARY_URL = "http://norvig.com/ngrams/enable1.txt";
	
	private final static List<String> VALID_GAME_WORDS = new ArrayList<>();
	
	private static Map<Integer, List<String>> WORD_LENGTH_DICTIONARY = new HashMap<>();
	
	/**
	 * Class constructor for the dictionary object, and its internal data. 
	 */
	public WordSquareDictionary()
	{
		loadWordList();
		produceWordMap();
	}
	
	/**
	 * Gets all of the words valid in the square for the provided word length. 
	 * 
	 * @param wordLength The length of all of the valid words to get from the dictionary. 
	 * @return All of the valid words in the square for the provided word length. 
	 */
	public List<String> getValidWordsOfLength(final int wordLength)
	{		
		List<String> validGameWords;
		
		if(WORD_LENGTH_DICTIONARY.containsKey(wordLength))
		{
			validGameWords = WORD_LENGTH_DICTIONARY.get(wordLength);
		}
		else
		{
			validGameWords = new ArrayList<>();
		}
		
		return validGameWords;
	}
	
	private void loadWordList() 
	{
		try {
			final BufferedReader reader = createDictionaryBufferedReader();
			
			createWordList(reader);
			
			closeBufferedReader(reader);
			
		} catch (IOException e) {
					
			System.out.println(
					String.format("IOException thrown while reading in the dictionary from %s", DICTIONARY_URL));
		}
	}
	
	private void produceWordMap()
	{
	  WORD_LENGTH_DICTIONARY = VALID_GAME_WORDS.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
	}
	
	
	private BufferedReader createDictionaryBufferedReader() throws IOException
	{
		final URL url = new URL(DICTIONARY_URL);
		return new BufferedReader(new InputStreamReader(url.openStream()));
	}
	
	private void closeBufferedReader(BufferedReader reader) throws IOException
	{
		reader.close();
	}
	
	private void createWordList(BufferedReader dictionaryBufferedReader) throws IOException
	{
		String inputLine;
		
		while((inputLine = dictionaryBufferedReader.readLine()) != null){
			VALID_GAME_WORDS.add(inputLine.trim().toLowerCase());
		}
	}
}
