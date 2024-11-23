package org.example.sorting;

import org.example.sorting.stategies.SortingStrategy;

public class Sorter<T> {
    private SortingStrategy<T> strategy;

    public Sorter(SortingStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(T[] array) {
        strategy.sort(array);
    }
}
