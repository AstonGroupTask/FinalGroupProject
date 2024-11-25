package org.example.menu.dataEntry;

import org.example.menu.BaseVariant;
import org.example.util.validate.TypeValidation;

public final class EnterData extends BaseVariant {

    private DataEntryStrategy dataEntryStrategy;

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
                case 1:
                    dataEntryStrategy = new ManualDataEntryStrategy();
                    break;
                case 2:
                    dataEntryStrategy = new RandomDataEntryStrategy();
                    break;
                case 3:
                    dataEntryStrategy = new FileDataEntryStrategy();
                    break;
                default:
                    break;
            }

            if (validVariant == 4) {
                System.out.println("Return to main menu");
                break;
            }
            
            if (dataEntryStrategy != null) {
                dataEntryStrategy.execute(array, scannerValidate);
            }
            printData();
        }
    }
    
	private void printData() {
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}
}
