package org.example.util.validate;

public class BasicValidators {

    public static String validateString(String input, int minLength, int maxLength, boolean noNull) {
        input = input.trim();
        if (input.isEmpty() && noNull) {
            throw new IllegalArgumentException("Ввод не должен быть пустым. Попробуйте снова.");
        }
        if (input.length() < minLength) {
            throw new IllegalArgumentException("Длина строки должна быть не меньше " + minLength + " символов.");
        }
        if (input.length() > maxLength) {
            throw new IllegalArgumentException("Длина строки не должна превышать " + maxLength + " символов.");
        }
        return input;
    }

    public static Integer validateInteger(String input, int min, int max) {
        try {
            int number = Integer.parseInt(input);
            if (number < min) {
                throw new IllegalArgumentException("Число не может быть меньше " + min + ".");
            }
            if (number > max) {
                throw new IllegalArgumentException("Число не может быть больше " + max + ".");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введено неверное число.");
        }
    }

    public static Float validateFloat(String input, float min, float max) {
        try {
            float number = Float.parseFloat(input);
            if (number < min) {
                throw new IllegalArgumentException("Число не может быть меньше " + min + ".");
            }
            if (number > max) {
                throw new IllegalArgumentException("Число не может быть больше " + max + ".");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Введено неверное число с плавающей точкой.");
        }
    }

    public static Boolean validateBoolean(String input) {
        if (input.equalsIgnoreCase("true")) {
            return true;
        } else if (input.equalsIgnoreCase("false")) {
            return false;
        } else {
            throw new IllegalArgumentException("Ожидается значение true или false.");
        }
    }
}
