package org.example.menu;

import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public final class SearchData extends BaseVariant {

	SingletoneArray array = SingletoneArray.getInstance();
	
    @Override
    public void menu() {
        System.out.println("Data input mode selected");

        int validVariant = 0;

        while (true) {
            System.out.println("Please, select type of input:");
            System.out.println(" 1 - Manual data entry");
            System.out.println(" 2 - Random data");
            System.out.println(" 3 - Read data from file");
            System.out.println(" 4 - Exit");

            System.out.print("Please, enter your chosen action: ");
            validVariant = (int) scannerValidate.getValidValue(TypeValidation.VARIANTS_4);
              
            switch (validVariant) {
			case (1):
				//enterData.menu();
				break;
			case (2):
				// Код2;
				break;
			case (3):
				// КодN;
				break;
			default:
			}
            if (validVariant == 4) {
                System.out.println("Return to main menu");
                break;
            }
        }
    }
}
