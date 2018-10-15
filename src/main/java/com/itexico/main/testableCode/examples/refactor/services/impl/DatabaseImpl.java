package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.services.Database;

public class DatabaseImpl implements Database {
    @Override
    public Invoice getInvoice(Integer invoiceId) {
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setTotal(100F);
        invoice.setEmail("valid@email");
        invoice.setOverdue(false);
        return invoice;
    }

    @Override
    public void save(Invoice invoice) {
        System.out.println(invoice.getId() + " saved");
    }
}
