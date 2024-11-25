package org.example.util.search.comparators.animal;

import java.util.Comparator;

import org.example.essence.Animal;

public final class SpeciesComparator<A extends Animal> implements Comparator<A> {
	
	public int compare(A a1, A a2) {
		return a1.getSpecies().compareTo(a2.getSpecies());
	}
}
