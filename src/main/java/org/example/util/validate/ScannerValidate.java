package org.example.util.validate;

import java.util.Scanner;

public class ScannerValidate {

	private Scanner scanner = new Scanner(System.in);

	public Object getValidValue(TypeValidation type) {
		while (true) {
			String input = scanner.nextLine().trim();
			try {
				Validator<?> validator = ValidatorFactory.getValidator(type);
				return validator.validate(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				System.out.print("Please, try again: ");
			}
		}
	}

	public static void main(String[] args) {
		ScannerValidate scannerValidate = new ScannerValidate();

		System.out.println("Выберите вариант от 1 до 3: ");
		int validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_3);
		System.out.println("Вы выбрали вариант: " + validVariant);

		System.out.println("Введите строку (от 1 до 99 символов): ");
		String validString = (String) scannerValidate.getValidValue(TypeValidation.STRING);
		System.out.println("Вы ввели строку: " + validString);

		System.out.println("Введите число (от 0 до 2000): ");
		int validInt = (int) scannerValidate.getValidValue(TypeValidation.INT);
		System.out.println("Вы ввели число: " + validInt);

		System.out.println("Введите число с плавающей точкой (от 0.0 до 100.0): ");
		float validFloat = (float) scannerValidate.getValidValue(TypeValidation.FLOAT);
		System.out.println("Вы ввели число с плавающей точкой: " + validFloat);

		System.out.println("Введите булевое значение (true/false): ");
		boolean validBoolean = (boolean) scannerValidate.getValidValue(TypeValidation.BOOLEAN);
		System.out.println("Вы ввели булево значение: " + validBoolean);
	}
}
