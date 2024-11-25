package org.example.util.search.comparators.barrel;

import java.util.Comparator;

import org.example.essence.Barrel;

public class StoredMaterialComparator<B extends Barrel> implements Comparator<B> {
	
	public int compare(B b1, B b2) {
		return b1.getSecondParam().compareTo(b2.getSecondParam());
	}
}
