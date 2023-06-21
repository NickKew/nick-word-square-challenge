package main.java.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Permutations 
{

	/**
     * Gets the list of all permutations from the list.
     * 
     * @param <T> The type of Object we are permutating.
     * @param listToPermutate The list of items to permutate over.
     * @return A stream of all permutations. 
     * 	       
     * Example: If listToPermutate is {1,2}
     * Output:  {(1,2), (2,1)}
     */
	public static <T> List<List<T>> getAllPermutationsList(final List<T> listToPermutate)
	{
		final Stream<List<T>> allPermutationsStream = getAllListpermutations(listToPermutate);
		
		return allPermutationsStream.collect(Collectors.toList());
	}
	
	/**
     * Gets the list of all permutations from the list of size r.
     * 
     * @param <T> The type of Object we are permutating.
     * @param listToPermutate The list of items to permutate over.
     * @param permutationSize The amount of items to put into the list of permutaions.
     * @return A stream of all permutations. 
     * 	       
     * Example: If listToPermutate is {1,2} and itemAmountInPermutation  is 2.
     * Output:  {(1,2), (2,1)}
     */
	public static <T> List<List<T>> getAllPermutationsListOfSize(final List<T> listToPermutate, final int permutationSize)
	{
		final Stream<List<T>> allPermutationsStream = getAllListpermutationsStreamOfSize(listToPermutate, permutationSize);
		
		return allPermutationsStream.collect(Collectors.toList());
	}
	
	private static <T> Stream<List<T>> getAllListpermutations(final List<T> listToPermutate)
	{
		return getAllListpermutationsStreamOfSize(listToPermutate, listToPermutate.size());
	}

    private static <T> Stream<List<T>> getAllListpermutationsStreamOfSize(final List<T> listToPermutate, final int permutationSize){
        if (permutationSize==1){
            return listToPermutate.stream()
                    .map(e -> Arrays.asList(e));
        } else
        if (permutationSize==2){
            return listToPermutate.stream()
                    .flatMap(
                            e1 -> listToPermutate.stream()  // e1: refers to an element of c
                                    .filter(e2 -> !e1.equals(e2)) // e2: refers to an element of c
                                    .map(e2 -> Arrays.asList(e1, e2))
                    );
        } else {
            return getAllListpermutationsStreamOfSize(listToPermutate, permutationSize-1)
                    .flatMap(
                            l -> listToPermutate.stream()
                                    .filter( e -> l.contains(e) == false)
                                    .map(e -> {
                                        List<T> out = new ArrayList<>();
                                        out.addAll(l);
                                        out.add(e);
                                        return out;}
                                    )
                    );
        }
    }
}

