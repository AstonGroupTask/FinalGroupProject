package org.example.util.search.comparators.barrel;

import java.util.Comparator;

import org.example.essence.Barrel;

public class VolumeComparator<B extends Barrel> implements Comparator<B> {
	
	public int compare(B b1, B b2) {
		return Double.compare(b1.getVolume(), b2.getVolume());
	}
}
