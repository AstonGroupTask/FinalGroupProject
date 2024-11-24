package org.example.menu;

import org.example.util.validate.ScannerValidate;
import org.example.util.validate.TypeValidation;

public abstract class BaseVariant {
    protected ScannerValidate scannerValidate = new ScannerValidate();
    
    public abstract void menu();
}