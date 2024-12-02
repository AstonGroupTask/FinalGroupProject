package org.example.sorting.stategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSort<T extends Comparable<T>> implements SortingStrategy<T> {
    @Override
    public void sort(T[] array) {

        List<T> evenElements = new ArrayList<>();
        List<Integer> oddIndices = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i])) {
                evenElements.add(array[i]);
            } else {
                oddIndices.add(i);
            }
        }


        T[] evenArray = (T[]) evenElements.toArray(new Comparable[0]);
        Arrays.sort(evenArray);


        int evenIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (oddIndices.contains(i)) {
                continue;
            }
            array[i] = evenArray[evenIndex++];
        }
    }

    private static boolean isEven(Comparable<?> value) {
        if (value instanceof Integer) {
            return ((Integer) value) % 2 == 0;
        }
        throw new IllegalArgumentException("Unsupported type");
    }
}

