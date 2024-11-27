package org.example.menu.dataSearch;

import java.lang.reflect.Field;
import org.example.menu.BaseVariant;
import org.example.menu.dataSort.CustomSort;
import org.example.menu.dataSort.SortData;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.search.BinarySearchGeneric;
import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public final class SearchData extends BaseVariant {

	@Override
	public void menu() {
		boolean continueSearch = true;

		while (continueSearch) {
			System.out.println("Data search mode selected");

			if (array.isEmpty()) {
				System.out.println("(!)No entities found \n(!)Return to main menu");
				return;
			}

			System.out.println("Stored entities:");
			System.out.println("=====================================");
			array.printStored();
			System.out.println("=====================================");

			System.out.println("The type of existing entity is: " + array.getStoredTypeSimple());

			SortData sortData = new SortData();
			String sortByField = sortData.printFields(array.get(0).getClass());
			
			CustomSort customSort = new CustomSort();
			customSort.setSortBy(sortByField);
			
			array.sort(customSort);

			System.out.print("Enter search field value: ");
			String searchFieldValue = (String) scannerValidate.getValidValue(TypeValidation.STRING_RUS);

			Object[] copiedArray = array.getCopy();

			int locatedAtIndex = BinarySearchGeneric.binarySearch(copiedArray, sortByField, searchFieldValue);

			if (locatedAtIndex == -1) {
				System.out.println("No entities find");
				System.out.print("Would you like to search again? (Yes/No): ");
				String response = (String) scannerValidate.getValidValue(TypeValidation.STRING);

				if (response.equalsIgnoreCase("No")) {
					System.out.println("Exiting search mode...");
					continueSearch = false;
				}
				continue;
			} else {
				int left = locatedAtIndex;
				int right = locatedAtIndex;

				while (left - 1 >= 0) {
					try {
						Field field = copiedArray[left - 1].getClass().getDeclaredField(sortByField);
						field.setAccessible(true);

						if (field.get(copiedArray[left - 1]).equals(searchFieldValue)) {
							left--;
						} else {
							break;
						}
					} catch (NoSuchFieldException e) {
						System.out.println("Field " + sortByField + " was not found for entity: "
								+ copiedArray[left - 1].getClass().getName());
						break;
					} catch (IllegalAccessException e) {
						System.out.println("Field access error: " + e.getMessage());
						break;
					}
				}

				while (right + 1 < array.size()) {
					try {
						Field field = copiedArray[right + 1].getClass().getDeclaredField(sortByField);
						field.setAccessible(true);

						if (field.get(copiedArray[right + 1]).equals(searchFieldValue)) {
							right++;
						} else {
							break;
						}
					} catch (NoSuchFieldException e) {
						System.out.println("Field " + sortByField + " was not found for entity: "
								+ copiedArray[right + 1].getClass().getName());
						break;
					} catch (IllegalAccessException e) {
						System.out.println("Field access error: " + e.getMessage());
						break;
					}
				}

				if (left != right)
					System.out.println("Found entity");
				else
					System.out.println("Found entities");
				System.out.println("=====================================");
				for (int idx = left; idx <= right; idx++) {
					System.out.println(" " + copiedArray[idx]);
				}
				System.out.println("=====================================");
			}

			System.out.print("Would you like to search again? (Yes/No): ");
			String response = (String) scannerValidate.getValidValue(TypeValidation.STRING);

			if (response.equalsIgnoreCase("No")) {
				System.out.println("Exiting search mode...");
				continueSearch = false;
			}
		}
	}
}
