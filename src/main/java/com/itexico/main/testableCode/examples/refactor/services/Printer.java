package com.itexico.main.testableCode.examples.refactor.services;

import com.itexico.main.testableCode.examples.refactor.entities.PrinterObject;
import com.itexico.main.testableCode.examples.refactor.exceptions.PrinterLockedException;

public interface Printer {
    void print(PrinterObject printerObject) throws PrinterLockedException;
}
