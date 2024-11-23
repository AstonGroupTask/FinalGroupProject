package org.example.util.search;

import java.util.ArrayList;

public class SearchContext <E> {
	
	private SearchStrategy<E> searchStrategy;
	
	public void setSearchStrategy(SearchStrategy<E> strategy) {
		this.searchStrategy = strategy;
	}

	public E executeSearchStrategy(ArrayList<E> collection, Integer collectionSize, E searchTarget) {
		return searchStrategy.binarySearch(collection, collectionSize, searchTarget);
	}
}
