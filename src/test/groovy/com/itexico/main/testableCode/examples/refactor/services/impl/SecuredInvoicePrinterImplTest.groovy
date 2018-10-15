package com.itexico.main.testableCode.examples.refactor.services.impl

import com.itexico.main.testableCode.examples.refactor.entities.Invoice
import com.itexico.main.testableCode.examples.refactor.entities.User
import com.itexico.main.testableCode.examples.refactor.exceptions.UserNotAuthorizedException
import com.itexico.main.testableCode.examples.refactor.services.Database
import com.itexico.main.testableCode.examples.refactor.services.Identity
import com.itexico.main.testableCode.examples.refactor.services.InvoicePrinter
import com.itexico.main.testableCode.examples.refactor.services.Security
import spock.lang.Specification

class SecuredInvoicePrinterImplTest extends Specification {

    def "Print invoice when user is admin"() {
        given: "a invoicePrinter"
        def invoicePrinter = Mock(InvoicePrinter)
        def security = Mock(Security)
        def identity = Mock(Identity)
        def database = Mock(Database)
        def securedInvoicePrinter =
                new SecuredInvoicePrinterImpl(
                        invoicePrinter, security,
                        identity, database)

        and: "an invoice"
        def invoice = new Invoice()

        and: "an admin user"
        def user = new User(username: "one user")
        identity.currentUser >> user
        security.isAdmin(user) >> true

        when: "I print an invoice"
        securedInvoicePrinter.printInvoice(invoice)

        then: "it is printed"
        1 * invoicePrinter.printInvoice(invoice)

        and: "the printing user is registered"
        1 * database.save({ it.printedByUser == user })
    }

    def "Throw an exception when printing an invoice by a non-admin user"() {
        given: "a invoicePrinter"
        def invoicePrinter = Mock(InvoicePrinter)
        def security = Mock(Security)
        def identity = Mock(Identity)
        def database = Mock(Database)
        def securedInvoicePrinter = new SecuredInvoicePrinterImpl(invoicePrinter, security, identity, database)

        and: "an invoice"
        def invoice = new Invoice()

        and: "a non-admin user"
        def user = new User(username: "one user")
        identity.currentUser >> user
        security.isAdmin(user) >> false

        when: "I print an invoice"
        securedInvoicePrinter.printInvoice(invoice)

        then: "it is not printed"
        0 * invoicePrinter.printInvoice(_)

        and: "an exception is thrown"
        thrown(UserNotAuthorizedException)
    }

}
