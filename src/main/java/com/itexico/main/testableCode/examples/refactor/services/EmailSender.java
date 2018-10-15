package com.itexico.main.testableCode.examples.refactor.services;

import com.itexico.main.testableCode.examples.refactor.entities.Invoice;
import com.itexico.main.testableCode.examples.refactor.exceptions.NullEmailAddressException;

public interface EmailSender {
    void sendInvoice(Invoice invoice) throws NullEmailAddressException;
}
