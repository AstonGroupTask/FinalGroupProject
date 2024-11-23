package org.example.util.validate;

public enum TypeValidation {
    STRING(String.class, 1, 99, true),  
    INT(Integer.class, 0, 2000, false), 
    FLOAT(Float.class, 0.0f, 100.0f, false),
    BOOLEAN(Boolean.class, 0, 0, false); 

    private final Class<?> type;
    private final Object min;
    private final Object max;
    private final boolean noNull;

    TypeValidation(Class<?> type, Object min, Object max, boolean noNull) {
        this.type = type;
        this.min = min;
        this.max = max;
        this.noNull = noNull;
    }

    public Class<?> getType() {
        return type;
    }

    public Object getMin() {
        return min;
    }

    public Object getMax() {
        return max;
    }

    public boolean hasNoNull() {
        return noNull;
    }
}