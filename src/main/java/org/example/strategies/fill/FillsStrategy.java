package org.example.strategies.fill;

public interface FillsStrategy<T> {
    T[] fill(int size);  // Метод для случайного и ручного ввода (без пути)

    Object[] fillFromFile(int size, String filePath);
}
