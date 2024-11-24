package org.example.util.validate;

public class ValidatorFactory {

	public static Validator<?> getValidator(TypeValidation type) {

		Object min = type.getMin();
		Object max = type.getMax();
		boolean noNull = type.hasNoNull();
		String regex = type.getRegex();

		switch (type.getType().getSimpleName()) {
		case "String":
			return (Validator<String>) (input) -> BasicValidators.validateString(input, (int) min, (int) max, noNull,
					regex);
		case "Integer":
			return (Validator<Integer>) (input) -> BasicValidators.validateInteger(input, (int) min, (int) max);
		case "Float":
			return (Validator<Float>) (input) -> BasicValidators.validateFloat(input, (float) min, (float) max);
		case "Boolean":
			return (Validator<Boolean>) (input) -> BasicValidators.validateBoolean(input);
		default:
			throw new IllegalArgumentException("Неизвестный тип данных: " + type);
		}
	}
}
