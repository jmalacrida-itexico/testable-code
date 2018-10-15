package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.PrinterObject;
import com.itexico.main.testableCode.examples.refactor.exceptions.PrinterLockedException;
import com.itexico.main.testableCode.examples.refactor.services.Printer;
import com.itexico.main.testableCode.examples.refactor.services.PrinterManager;

import javax.inject.Inject;

public class PrinterImpl implements Printer {

    private PrinterManager printerManager;

    @Inject
    public PrinterImpl(PrinterManager printerManager) {
        this.printerManager = printerManager;
    }

    @Override
    public void print(PrinterObject printerObject) throws PrinterLockedException {
        printerManager.acquireLock();
        setPageColor(printerObject.getPageColor());
        printerObject.getLines().forEach(this::writeLine);
        printerManager.releaseLock();
    }

    private void writeLine(String line) {
        System.out.println(line);
    }

    private void setPageColor(String pageColor) {
        System.out.println("Color " + pageColor);
    }
}
