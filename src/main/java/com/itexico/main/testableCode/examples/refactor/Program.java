package com.itexico.main.testableCode.examples.refactor;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.itexico.main.testableCode.examples.refactor.config.InvoiceModule;
import com.itexico.main.testableCode.examples.refactor.services.InvoiceGenerator;

import java.util.Map;

public class Program {
    public static void main(String... args) {
        Integer invoiceId = Integer.valueOf(args[0]);
        String action = args[1];

        Injector injector = Guice.createInjector(new InvoiceModule());
        Map<String, InvoiceGenerator> map = injector
                .getInstance(Key.get(new TypeLiteral<Map<String, InvoiceGenerator>>() {}));

        InvoiceGenerator invoiceGenerator = map.get(action);
        invoiceGenerator.sendInvoice(invoiceId);
    }
}
