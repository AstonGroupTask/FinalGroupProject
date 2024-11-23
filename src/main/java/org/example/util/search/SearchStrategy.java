package org.example.util.search;

import java.util.ArrayList;

public interface SearchStrategy <E> {
	
	public <E> E binarySearch(ArrayList<E> collection, Integer collectionSize, E searchTarget);
}