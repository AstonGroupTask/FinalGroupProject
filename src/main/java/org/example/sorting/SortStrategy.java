package org.example.sorting;

public interface SortStrategy <T extends Comparable<T>> {
    void sort(T[] array);
}
