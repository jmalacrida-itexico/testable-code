package com.itexico.main.testableCode.examples.original;

class Database {
    Invoice getInvoice(Integer invoiceId) {
        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setEmail("valid@email");
        invoice.setOverdue(false);
        invoice.setTotal(100F);
        return invoice;
    }

    void save(Invoice invoice) {
        System.out.println("save " + invoice.getId());
    }
}
