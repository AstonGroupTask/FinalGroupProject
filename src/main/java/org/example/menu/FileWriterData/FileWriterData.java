package org.example.menu.FileWriterData;

import org.example.menu.BaseVariant;
import org.example.util.validate.TypeValidation;
import org.example.util.FileWriter;

public final class FileWriterData extends BaseVariant {

	@Override
	public void menu() {
		System.out.println("Data File Write mode selected");
		
		System.out.println("Stored entities:");
		System.out.println("=====================================");
		array.printStored();
		System.out.println("=====================================");

		
		System.out.print("Please, enter your file path: ");
		String filePath = (String) scannerValidate.getValidValue(TypeValidation.STRING_FILE_PATH);
		
		Object[] copiedArray = array.getCopy();
		
		FileWriter fileWriter = new FileWriter();
		fileWriter.writeArrayToFile(filePath, copiedArray);
		
		System.out.println("File writting complete");
		System.out.println("Return to menu");
	}
}
