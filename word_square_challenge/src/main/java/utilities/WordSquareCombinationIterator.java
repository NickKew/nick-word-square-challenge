package main.java.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Iterator for all of the combinations for a list of items.
 */
public class WordSquareCombinationIterator implements Iterable<List<String>>, Iterator<List<String>>{

	private List<String> items;
	private int choose;
	private boolean finished;
	private int[] current;
	
	public WordSquareCombinationIterator(List<String> items, int choose)
	{
		if(items == null || items.size() == 0)
		{
			throw new IllegalArgumentException("items");
		}
		
		if(choose <= 0 || choose > items.size())
		{
			throw new IllegalArgumentException("choose");
		}
		
		this.items = items;
		this.choose = choose;
		this.finished = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNext() {
		return !finished;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> next() 
	{
		if (!hasNext()) {
            throw new NoSuchElementException();
        }

        if (current == null) {
            current = new int[choose];
            for (int i = 0; i < choose; i++) {
                current[i] = i;
            }
        }

        List<String> result = new ArrayList<String>(choose);
        for (int i = 0; i < choose; i++) {
            result.add(items.get(current[i]));
        }

        int n = items.size();
        finished = true;
        for (int i = choose - 1; i >= 0; i--) {
            if (current[i] < n - choose + i) {
                current[i]++;
                for (int j = i + 1; j < choose; j++) {
                    current[j] = current[i] - i + j;
                }
                finished = false;
                break;
            }
        }

        return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<List<String>> iterator() {
		return this;	
	}
	
}
