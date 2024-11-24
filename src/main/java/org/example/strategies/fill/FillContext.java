package org.example.strategies.fill;

public class FillContext<T> {
    private FillsStrategy<T> fillStrategy;

    public void setFillStrategy(FillsStrategy<T> fillStrategy) {
        this.fillStrategy = fillStrategy;
    }

    public T[] fillArray(int size) {
        if (fillStrategy == null) {
            throw new IllegalStateException("Стратегия заполнения не установлена.");
        }
        return fillStrategy.fill(size);
    }
}