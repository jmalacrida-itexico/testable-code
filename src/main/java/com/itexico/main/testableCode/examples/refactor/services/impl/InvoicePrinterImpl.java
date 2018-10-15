package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.entities.PrinterObject;
import com.itexico.main.testableCode.examples.refactor.exceptions.InvoicePrinterException;
import com.itexico.main.testableCode.examples.refactor.exceptions.PrinterLockedException;
import com.itexico.main.testableCode.examples.refactor.services.DateWrapper;
import com.itexico.main.testableCode.examples.refactor.services.InvoicePrinter;
import com.itexico.main.testableCode.examples.refactor.services.Printer;
import com.itexico.main.testableCode.examples.refactor.services.PrinterProperties;

import javax.inject.Inject;

public class InvoicePrinterImpl
        implements InvoicePrinter {

    private Printer printer;
    private DateWrapper dateWrapper;
    private PrinterProperties printerProperties;

    @Inject
    public InvoicePrinterImpl(
            Printer printer,
            DateWrapper dateWrapper,
            PrinterProperties printerProperties) {
        this.printer = printer;
        this.dateWrapper = dateWrapper;
        this.printerProperties = printerProperties;
    }

    public void printInvoice(Invoice invoice) throws InvoicePrinterException {
        String pageColor = (invoice.isOverdue())
                ? printerProperties.getOverdueColor()
                : printerProperties.getDefaultColor();
        PrinterObject printerObject = new PrinterObject()
                .withPageColor(pageColor)
                .appendLine("Invoice Id: " + invoice.getId())
                .appendLine("Total: " + invoice.getTotal())
                .appendLine("Printed: " + dateWrapper.getNowAsIsoLocalDate());
        try {
            printer.print(printerObject);
        } catch (PrinterLockedException e) {
            throw new InvoicePrinterException(e);
        }
    }
}
