package com.itexico.main.testableCode.examples.refactor.services;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;

public interface Database {
    Invoice getInvoice(Integer invoiceId);

    void save(Invoice invoice);
}
