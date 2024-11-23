package org.example.sorting.stategies;

import java.util.Arrays;

public class TimSort<T extends Comparable<T>> implements SortingStrategy<T> {

    private static final int RUN = 32;

    @Override
    public void sort(T[] array) {
        int n = array.length;

        for (int start = 0; start < n; start += RUN) {
            int end = Math.min(start + RUN, n);
            insertionSort(array, start, end);
        }

        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = Math.min(left + size, n);
                int right = Math.min(left + 2 * size, n);

                if (mid < right) {
                    merge(array, left, mid, right);
                }
            }
        }
    }


    private void insertionSort(T[] array, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= left && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }


    private void merge(T[] array, int left, int mid, int right) {
        int leftSize = mid - left;
        int rightSize = right - mid;

        T[] leftArray = Arrays.copyOfRange(array, left, mid);
        T[] rightArray = Arrays.copyOfRange(array, mid, right);

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }
}
