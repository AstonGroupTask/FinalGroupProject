package org.example.util.search.comparators.barrel;

import java.util.Comparator;

import org.example.essence.Barrel;

public class MaterialMadeOfComparator<B extends Barrel> implements Comparator<B> {
	
	public int compare(B b1, B b2) {
		return b1.getThirdParam().compareTo(b2.getThirdParam());
	}
}
