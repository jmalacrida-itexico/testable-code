package com.itexico.main.testableCode.examples.original;

public class Program {
    public static void main(String... args) {
        Integer invoiceId = Integer.valueOf(args[0]);
        String action = args[1];
        Container container = new Container();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(container, invoiceId);
        try {
            switch (action) {
                case "print":
                    PrinterManager.initialize();
                    invoiceGenerator.printOrEmailInvoice(false);
                    break;
                case "email":
                    invoiceGenerator.printOrEmailInvoice(true);
            }
        } catch (NullEmailAddressException e) {
            // exception handling
        } catch (UserNotAuthorizedException e) {
            // exception handling
        }
    }
}
