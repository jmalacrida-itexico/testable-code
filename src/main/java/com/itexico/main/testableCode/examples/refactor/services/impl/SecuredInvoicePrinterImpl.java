package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.entities.User;
import com.itexico.main.testableCode.examples.refactor.exceptions.InvoicePrinterException;
import com.itexico.main.testableCode.examples.refactor.exceptions.UserNotAuthorizedException;
import com.itexico.main.testableCode.examples.refactor.services.*;
import com.itexico.main.testableCode.examples.refactor.services.InvoicePrinter;

import javax.inject.Inject;
import javax.inject.Named;

public class SecuredInvoicePrinterImpl
        implements InvoicePrinter {
    private InvoicePrinter invoicePrinter;
    private Security security;
    private Identity identity;
    private Database database;

    @Inject
    public SecuredInvoicePrinterImpl(
            @Named("invoicePrinter") InvoicePrinter invoicePrinter,
            Security security,
            Identity identity,
            Database database) {
        this.invoicePrinter = invoicePrinter;
        this.security = security;
        this.identity = identity;
        this.database = database;
    }

    public void printInvoice(Invoice invoice) throws InvoicePrinterException {
        User user = identity.getCurrentUser();
        if (!security.isAdmin(user)) {
            throw new UserNotAuthorizedException();
        }
        invoicePrinter.printInvoice(invoice);
        invoice.setPrintedByUser(user);
        database.save(invoice);
    }
}
