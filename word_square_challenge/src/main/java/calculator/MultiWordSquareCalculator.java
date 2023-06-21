package main.java.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import main.java.models.GridSolution;

/**
 * Class for calculating the possible solutions for a multiple word squares in a txt file.
 */
public class MultiWordSquareCalculator {
	
	private final static List<String> GRID_SQUARE_PARAMETERS = new ArrayList<>();
	
	
	/**
	 * Computes the word squares contained within the txt file of parameters.
	 * 
	 * @param txtFileLocation The location to the txt file containing the word square parameters.
	 */
	public static List<GridSolution> computeMultipleGridSquareSolutions(final String txtFileLocation)
	{
		final List<GridSolution> gridSolutions = new ArrayList<>();
		
		loadWordSquareList(txtFileLocation);
		
		for(final String gridSquareParameters : GRID_SQUARE_PARAMETERS)
		{	
			gridSolutions.addAll(computeGridSolutionFor(gridSquareParameters));
		}
		
		return gridSolutions;
	}
	
	private static List<GridSolution> computeGridSolutionFor(final String gridSquareParameters)
	{
		final String[] gridRequirements = gridSquareParameters.split(" ", 2);
		
		final int gridSize = getGridSizeArgument(gridRequirements);
		final String gridLetters = getGridLetterArgument(gridRequirements);
		
		return SingleWordSquareCalculator.calculateValidWordSquares(gridSize, gridLetters);
	}
	
	private static int getGridSizeArgument(final String[] gridRequirements)
	{
		return Integer.parseInt(gridRequirements[0]);
	}
	
	private static String getGridLetterArgument(final String[] gridRequirements)
	{
		return gridRequirements[1];
	}
	
	private static void loadWordSquareList(final String txtFileLocation) 
	{
		
		try {
			final File file = createFileFor(txtFileLocation);
			final BufferedReader reader = createBufferedReaderFor(file);

			processLinesInFile(reader);
			
			closeBufferedReader(reader);
		}
		catch(IOException exception)
		{
			System.out.println(
					String.format("IOException thrown while reading in the %s provided", txtFileLocation));

		}
	}
	
	private static File createFileFor(final String txtFileLocation)
	{
		return new File(txtFileLocation);
	}

	private static BufferedReader createBufferedReaderFor(final File file) throws FileNotFoundException
	{
		return new BufferedReader(new InputStreamReader (
			    new FileInputStream (file)));
	}
	
	private static void processLinesInFile(final BufferedReader bufferedReader) throws IOException
	{
		String gameLine;

		//Read File Line By Line
		while ((gameLine = bufferedReader.readLine()) != null)   
		{
			GRID_SQUARE_PARAMETERS.add(gameLine);
		}
	}
	
	private static void closeBufferedReader(final BufferedReader bufferedReader) throws IOException
	{
		bufferedReader.close();
	}
	
}
