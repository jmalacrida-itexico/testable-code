package com.itexico.main.testableCode.examples.refactor.services.impl

import com.itexico.main.testableCode.examples.refactor.entities.Invoice
import com.itexico.main.testableCode.examples.refactor.services.Database
import com.itexico.main.testableCode.examples.refactor.services.InvoicePrinter
import spock.lang.Specification

class InvoicePrintGeneratorTest extends Specification {
    def "Send a printed invoice"() {
        given: "an InvoicePrintGenerator"
        def database = Mock(Database)
        database.getInvoice(1) >> new Invoice(id: 1)
        def securedInvoicePrinter = Mock(InvoicePrinter)
        def invoicePrintGenerator = new InvoicePrintGenerator(database, securedInvoicePrinter)

        when: "I send a printed invoice"
        invoicePrintGenerator.sendInvoice(1)

        then: "it is sent"
        1 * securedInvoicePrinter.printInvoice({ it.getId() == 1 })
    }
}
