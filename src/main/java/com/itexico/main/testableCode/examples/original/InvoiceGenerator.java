package com.itexico.main.testableCode.examples.original;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InvoiceGenerator {
    private Container container;
    private Invoice invoice;
    private String pageColor;

    public InvoiceGenerator(
            Container container,
            Integer invoiceId) {
        this.container = container;
        this.invoice = container.getDatabase()
                .getInvoice(invoiceId);
        PropertiesReader propsReader =
                new PropertiesReader();
        this.pageColor = (invoice.isOverdue()) ?
                propsReader.getOverdueColor() :
                propsReader.getDefaultColor();
    }

    public void printOrEmailInvoice(boolean sendEmail)
            throws UserNotAuthorizedException, NullEmailAddressException {
        if (!sendEmail) {
            Security security = Security.getInstance();
            User user = container.getSession().getLogin().getUser();
            if (security.isAdmin(user)) {
                PrinterManager.acquireLock();
                Printer.setPageColor(pageColor);
                Printer.writeLine("Invoice Id: " + invoice.getId());
                Printer.writeLine("Total " + invoice.getTotal());
                Printer.writeLine("Printed: " + LocalDate.now()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE));
                PrinterManager.releaseLock();
                invoice.setPrintedByUser(user);
                container.getDatabase().save(invoice);
            } else
                throw new UserNotAuthorizedException();
        } else {
            if (invoice.getEmail() == null)
                throw new NullEmailAddressException();
            new EmailSender().sendInvoice(invoice);
        }
    }
}

