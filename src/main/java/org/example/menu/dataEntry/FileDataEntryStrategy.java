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

		FillFromFile<Object> fillStrategy = new FillFromFile<>();
		Object[] result = fillStrategy.fillFromFile(0, filePath);

		if (result == null) {
			System.out.print("File reading error");
			return;
		}

		for (Object entity : (Object[]) result[0]) {
			array.add(entity);
		}
		System.out.print("File reading complete");
	}
}
