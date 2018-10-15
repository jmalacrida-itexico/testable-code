package com.itexico.main.testableCode.examples.refactor.services.impl

import com.itexico.main.testableCode.examples.refactor.entities.Invoice
import com.itexico.main.testableCode.examples.refactor.exceptions.NullEmailAddressException
import com.itexico.main.testableCode.examples.refactor.services.Database
import com.itexico.main.testableCode.examples.refactor.services.EmailSender
import spock.lang.Specification

class InvoiceEmailGeneratorTest extends Specification {
    def "Send an invoice through email"() {
        given: "an InvoiceEmailGenerator"
        def database = Mock(Database)
        def emailSender = Mock(EmailSender)
        def invoiceEmailGenerator = new InvoiceEmailGenerator(database, emailSender)

        and: "an invoice with a valid email"
        database.getInvoice(1) >> new Invoice(id: 1, email: "a.valid@email.com")

        when: "I send an invoice through email"
        invoiceEmailGenerator.sendInvoice(1)

        then: "it is sent"
        1 * emailSender.sendInvoice({ it.getId() == 1 })
    }

}
