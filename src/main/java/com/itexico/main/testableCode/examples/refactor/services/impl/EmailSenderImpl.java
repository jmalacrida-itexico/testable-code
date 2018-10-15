package com.itexico.main.testableCode.examples.refactor.services.impl;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.exceptions.NullEmailAddressException;
import com.itexico.main.testableCode.examples.refactor.services.EmailSender;

public class EmailSenderImpl implements EmailSender {
    @Override
    public void sendInvoice(Invoice invoice) throws NullEmailAddressException {
        if (invoice.getEmail() == null)
            throw new NullEmailAddressException();
        System.out.println(invoice.getId() + " sent");
    }
}
