package org.example.util.validate;

public enum TypeValidation {
	STRING(String.class, 1, 99, true, "^[A-Za-z0-9]+$"), INT(Integer.class, 0, 2000, false, null),
	FLOAT(Float.class, 0.0f, 100.0f, false, null), BOOLEAN(Boolean.class, 0, 0, false, null),

	STRING_FILE_PATH(String.class, 1, 99, true,
			"^([A-Za-z]:\\\\|/)?([A-Za-z0-9_\\-\\/\\\\.]+(?:[\\/\\\\][A-Za-z0-9_\\-\\.]+)*)$"),
	STRING_EMPTY(String.class, 1, 99, true, "^[A-Za-z0-9]*$"), VARIANTS_3(Integer.class, 1, 3, false, null),
	VARIANTS_4(Integer.class, 1, 4, false, null);

	private final Class<?> type;
	private final Object min;
	private final Object max;
	private final boolean noNull;
	private final String regex;

	TypeValidation(Class<?> type, Object min, Object max, boolean noNull, String regex) {
		this.type = type;
		this.min = min;
		this.max = max;
		this.noNull = noNull;
		this.regex = regex;
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

	public String getRegex() {
		return regex;
	}
}