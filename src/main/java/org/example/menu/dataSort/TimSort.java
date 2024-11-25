package org.example.menu.dataSort;

import java.util.Arrays;

import org.example.singletoneArray.SingletoneArray;

public class TimSort implements SortingStrategy<Comparable> {
	private static final int RUN = 32;

	@Override
	public void sort(Object[] array) {
		int n = SingletoneArray.getInstance().size();

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

	private void insertionSort(Object[] array, int left, int right) {
		for (int i = left + 1; i < right; i++) {
			Comparable key = (Comparable) array[i];
			int j = i - 1;
			
			while (j >= left && ((Comparable) array[j]).compareTo(key) > 0) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	private void merge(Object[] array, int left, int mid, int right) {
		int leftSize = mid - left;
		int rightSize = right - mid;

		Object[] leftArray = Arrays.copyOfRange(array, left, mid);
		Object[] rightArray = Arrays.copyOfRange(array, mid, right);

		int i = 0, j = 0, k = left;

		while (i < leftSize && j < rightSize) {
			if (((Comparable) leftArray[i]).compareTo(rightArray[j]) <= 0) {
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
