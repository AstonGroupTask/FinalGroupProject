package org.example.singletoneArray;

import java.util.Arrays;

import org.example.menu.dataSort.SortingStrategy;

public final class SingletoneArray {

	private static volatile SingletoneArray instance;

	private Object[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	private Class<?> storedType;

	private SingletoneArray() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
		storedType = null;
	}

	public static SingletoneArray getInstance() {
		SingletoneArray localInstance = instance;

		if (localInstance == null) {
			synchronized (SingletoneArray.class) {
				localInstance = instance;

				if (localInstance == null) {
					instance = localInstance = new SingletoneArray();
				}
			}
		}
		return localInstance;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Object element) {
		if (storedType != null && !storedType.equals(element.getClass())) {
			throw new IllegalArgumentException(
					"Cannot add elements of different types. Only " + storedType.getName() + " is allowed.");
		}

		if (storedType == null) {
			storedType = element.getClass();
		}

		if (size == elements.length) {
			expandArray();
		}

		elements[size++] = element;
	}

	public Object get(int index) {
		if (index >= 0 && index < size) {
			return elements[index];
		}
		throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	}

	public int size() {
		return size;
	}

	private void expandArray() {
		int newCapacity = elements.length * 2;
		Object[] newArray = new Object[newCapacity];
		System.arraycopy(elements, 0, newArray, 0, elements.length);
		elements = newArray;
	}

	public String getStoredType() {
		if (size == 0) {
			return "No elements";
		}
		return storedType.getName();
	}

	public void sort(SortingStrategy<?> strategy) {
		if (storedType != null && Comparable.class.isAssignableFrom(storedType)) {
			strategy.sort(elements);
		} else {
			throw new IllegalStateException("Elements are not Comparable or no type is set.");
		}
	}
}
