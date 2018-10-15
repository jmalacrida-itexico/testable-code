package com.itexico.main.testableCode.examples.refactor.services.impl

import com.itexico.main.testableCode.examples.refactor.entities.Invoice
import com.itexico.main.testableCode.examples.refactor.services.DateWrapper
import com.itexico.main.testableCode.examples.refactor.services.Printer
import com.itexico.main.testableCode.examples.refactor.services.PrinterProperties
import spock.lang.Specification

class InvoicePrinterImplTest extends Specification {
    def "Print an invoice"() {
        given: "an invoice printer"
        def printer = Mock(Printer)
        def dateWrapper = Mock(DateWrapper)
        def printerProperties = Mock(PrinterProperties)
        def invoicePrinter = new InvoicePrinterImpl(printer, dateWrapper, printerProperties)

        dateWrapper.nowAsIsoLocalDate >> "2018-10-18"
        printerProperties.defaultColor >> "black"

        and: "an invoice"
        def invoice = new Invoice(id: 1, total: 100F, overdue: false)

        when: "I print an invoice"
        invoicePrinter.printInvoice(invoice)

        then: "it is printed"
        1 * printer.print({
            it.pageColor == "black" &&
                    it.lines.contains("Invoice Id: 1") &&
                    it.lines.contains("Total: 100.0") &&
                    it.lines.contains("Printed: 2018-10-18")
        })
    }
}
