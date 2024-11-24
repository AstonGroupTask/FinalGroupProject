package org.example.singletoneArray;

public final class SingletoneArray {

	private static volatile SingletoneArray instance;

	private Object[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	private SingletoneArray() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
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
		return size == 0 ? true : false;
	}

	public void add(Object element) {
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
}
