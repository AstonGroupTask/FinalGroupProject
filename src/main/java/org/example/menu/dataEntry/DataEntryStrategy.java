package org.example.menu.dataEntry;

import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.ScannerValidate;

public interface DataEntryStrategy {
	void execute(SingletoneArray array, ScannerValidate scannerValidate);
}