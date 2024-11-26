package org.example.menu;

import org.example.menu.FileWriterData.FileWriterData;
import org.example.menu.dataEntry.EnterData;
import org.example.menu.dataSearch.SearchData;
import org.example.menu.dataSort.SortData;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public final class Menu {

	ScannerValidate scannerValidate = new ScannerValidate();
	SingletoneArray array = SingletoneArray.getInstance();
	
	private static void clearConsole() {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			if (os.contains("win")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				new ProcessBuilder("clear").inheritIO().start().waitFor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		System.out.println("Welcome to SimpleDataBase");

		int validVariant = 0;
		
		EnterData enterData = new EnterData();
		SortData sortData = new SortData();
		SearchData searchData = new SearchData();
		FileWriterData fileWriterData = new FileWriterData();
		
		while (true) {
			// clearConsole(); TODO doesn't work in eclipse
			System.out.println("Stored entities:");
			System.out.println("=====================================");
			array.printStored();
			System.out.println("=====================================");
			
			System.out.println("Please, select one of three variants:");
			System.out.println(" 1 - Enter");
			System.out.println(" 2 - Sort");
			System.out.println(" 3 - Search");
			System.out.println(" 4 - Write");
			System.out.println(" 5 - Exit");

			System.out.print("Please, enter your chosen action: ");
			validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_5);
			
			switch (validVariant) {
			case (1):
				enterData.menu();
				break;
			case (2):
				sortData.menu();
				break;
			case (3):
				searchData.menu();
				break;
			case (4):
				fileWriterData.menu();
				break;
			default:
			}

			if (validVariant == 5) {
				System.out.println("Exiting...");
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.execute();
	}
}
