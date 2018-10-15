package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.exceptions.NullEmailAddressException;
import com.itexico.main.testableCode.examples.refactor.services.Database;
import com.itexico.main.testableCode.examples.refactor.services.EmailSender;
import com.itexico.main.testableCode.examples.refactor.services.InvoiceGenerator;

import javax.inject.Inject;

public class InvoiceEmailGenerator implements InvoiceGenerator {
    private Database database;
    private EmailSender emailSender;

    @Inject
    public InvoiceEmailGenerator(Database database, EmailSender emailSender) {
        this.database = database;
        this.emailSender = emailSender;
    }

    @Override
    public void sendInvoice(Integer invoiceId) {
        Invoice invoice = database.getInvoice(invoiceId);
        try {
            emailSender.sendInvoice(invoice);
        } catch (NullEmailAddressException e) {
            // Log exception properly
        }
    }
}
