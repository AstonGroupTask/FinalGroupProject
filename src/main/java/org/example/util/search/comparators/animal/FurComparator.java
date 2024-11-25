package org.example.util.search.comparators.animal;

import java.util.Comparator;

import org.example.essence.Animal;

public class FurComparator<A extends Animal> implements Comparator<A> {
	
	public int compare(A a1, A a2) {
		return Boolean.compare(a1.isHasFur(), a2.isHasFur());
	}
}
