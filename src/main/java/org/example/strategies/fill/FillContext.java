package org.example.strategies.fill;


public class FillContext {
    private FillsStrategy fillStrategy;

    public void setFillStrategy(FillsStrategy fillStrategy) {
        this.fillStrategy = fillStrategy;
    }

    public Comparable<?>[] fillArray(int size) {
        if (fillStrategy == null) {
            throw new IllegalStateException("Стратегия заполнения не установлена.");
        }
        return fillStrategy.fill();
    }
}