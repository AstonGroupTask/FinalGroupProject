package org.example.menu.dataSort;

import java.lang.reflect.Field;
import org.example.menu.BaseVariant;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public final class SortData extends BaseVariant {

	private final SingletoneArray array = SingletoneArray.getInstance();
	private final ScannerValidate scannerValidate = new ScannerValidate();

	@Override
	public void menu() {
		System.out.println("Data input mode selected");

		int validVariant = 0;

		while (true) {
			System.out.println("Please, select type of sort:");
			System.out.println(" 1 - TimSort");
			System.out.println(" 2 - Custom Sort");
			System.out.println(" 3 - Quick Sort");
			System.out.println(" 4 - Exit");

			System.out.print("Please, enter your chosen action: ");
			validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_4);

			switch (validVariant) {
			case 1:
				sort(new TimSort());
				break;
			case 2:
				sort(customSortMenu());
				break;
			case 3:
				// sort(new QuickSort());
				break;
			default:
				break;
			}

			if (validVariant == 4) {
				System.out.println("Return to main menu");
				break;
			}
		}
	}

	public CustomSort customSortMenu() {
		CustomSort customSort = new CustomSort();

		String sortByField = printFields(array.get(0).getClass());

		customSort.setSortBy(sortByField);
		return customSort;
	}

	public String printFields(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("Please, select field to sort");

		int selected_type = 0;

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(" " + (i + 1) + ". " + field.getName());
		}

		while (true) {
			System.out.print("Please, enter your chosen action: ");
			selected_type = (int) scannerValidate.getValidValue(TypeValidation.INT);
			if (selected_type <= fields.length)
				break;
			System.out.print("Invalid value");
		}

		return fields[selected_type - 1].getName();
	}

	public void sort(SortingStrategy<?> strategy) {
		System.out.println("Sorting data...");
		array.sort(strategy);
		System.out.println("Data sorting complete");
	}
}