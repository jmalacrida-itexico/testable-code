package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.exceptions.InvoicePrinterException;
import com.itexico.main.testableCode.examples.refactor.services.Database;
import com.itexico.main.testableCode.examples.refactor.services.InvoiceGenerator;
import com.itexico.main.testableCode.examples.refactor.services.InvoicePrinter;

import javax.inject.Inject;
import javax.inject.Named;

public class InvoicePrintGenerator implements InvoiceGenerator {
    private Database database;
    private InvoicePrinter invoicePrinter;

    @Inject
    public InvoicePrintGenerator(Database database, @Named("securedInvoicePrinter") InvoicePrinter invoicePrinter) {
        this.database = database;
        this.invoicePrinter = invoicePrinter;
    }

    @Override
    public void sendInvoice(Integer invoiceId) {
        Invoice invoice = database.getInvoice(invoiceId);
        try {
            invoicePrinter.printInvoice(invoice);
        } catch (InvoicePrinterException e) {
            // Log exception properly
        }
    }
}
