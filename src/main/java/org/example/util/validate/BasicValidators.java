package org.example.util.validate;

import java.util.regex.Pattern;

public class BasicValidators {

	public static String validateString(String input, int minLength, int maxLength, boolean noNull, String regex) {
		input = input.trim();

		if (input.isEmpty() && noNull) {
			throwIllegalArgumentException("Input cannot be empty");
		}

		if (input.length() < minLength) {
			throwIllegalArgumentException("The string length must be at least " + minLength + " characters.");
		}

		if (input.length() > maxLength) {
			throwIllegalArgumentException("The string length must not exceed " + maxLength + " characters.");
		}

		if (regex != null && !regex.isEmpty() && !Pattern.matches(regex, input)) {
			throwIllegalArgumentException("The string does not match the regular expression.");
		}

		return input;
	}

	public static Integer validateInteger(String input, int min, int max) {
		try {
			int number = Integer.parseInt(input);
			if (number < min) {
				throwIllegalArgumentException("The number cannot be less than " + min + ".");
			}
			if (number > max) {
				throwIllegalArgumentException("The number cannot be greater than " + max + ".");
			}
			return number;
		} catch (NumberFormatException e) {
			throwIllegalArgumentException("Invalid number entered.");
		}
		return null; 
	}

	public static Float validateFloat(String input, float min, float max) {
		try {
			float number = Float.parseFloat(input);
			if (number < min) {
				throwIllegalArgumentException("The number cannot be less than " + min + ".");
			}
			if (number > max) {
				throwIllegalArgumentException("The number cannot be greater than " + max + ".");
			}
			return number;
		} catch (NumberFormatException e) {
			throwIllegalArgumentException("Invalid floating point number entered.");
		}
		return null;
	}

	public static Boolean validateBoolean(String input) {
		if (input.equalsIgnoreCase("true")) {
			return true;
		} else if (input.equalsIgnoreCase("false")) {
			return false;
		} else {
			throwIllegalArgumentException("Expected value true or false.");
		}
		return null;
	}

	private static void throwIllegalArgumentException(String message) {
		throw new IllegalArgumentException(message);
	}
}
