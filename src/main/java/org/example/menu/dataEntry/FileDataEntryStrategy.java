package org.example.menu.dataEntry;

import org.example.strategies.fill.FillFromFile;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public class FileDataEntryStrategy implements DataEntryStrategy {
	@Override
	public void execute(SingletoneArray array, ScannerValidate scannerValidate) {
		System.out.print("Please, enter your file path: ");
		String filePath = (String) scannerValidate.getValidValue(TypeValidation.STRING_FILE_PATH);

		FillFromFile fillStrategy = new FillFromFile(filePath);
        Comparable<?>[] result = fillStrategy.fill();

		if (result == null) {
			System.out.print("File reading error");
			return;
		}

		for (Comparable<?> entity : result) {
			array.add(entity);
		}
		System.out.println("File reading complete");
	}
}
