package org.example.util.search.comparators.human;

import java.util.Comparator;

import org.example.essence.Human;

public class AgeComparator<H extends Human> implements Comparator<H> {
	
	public int compare(H h1, H h2) {
		return Integer.compare(h1.getAge(), h2.getAge());
	}
}
