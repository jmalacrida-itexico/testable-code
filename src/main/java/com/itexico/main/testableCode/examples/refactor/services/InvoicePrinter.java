package com.itexico.main.testableCode.examples.refactor.services;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.exceptions.InvoicePrinterException;

public interface InvoicePrinter {
    void printInvoice(Invoice invoice) throws InvoicePrinterException;
}
