package org.example.menu;

import org.example.util.validate.ScannerValidate;
import org.example.singletoneArray.SingletoneArray;
import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public abstract class BaseVariant {
    protected ScannerValidate scannerValidate = new ScannerValidate();
    protected SingletoneArray array = SingletoneArray.getInstance();
    
    public abstract void menu();
}