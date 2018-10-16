package com.itexico.main.testableCode.examples.refactor.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Names;
import com.itexico.main.testableCode.examples.refactor.services.*;
import com.itexico.main.testableCode.examples.refactor.services.impl.*;

import javax.inject.Singleton;

public class InvoiceModule extends AbstractModule {
    protected void configure() {
        bind(Database.class).to(DatabaseImpl.class).in(Scopes.SINGLETON);
        bind(DateWrapper.class).to(DateWrapperImpl.class);
        bind(EmailSender.class).to(EmailSenderImpl.class).in(Scopes.SINGLETON);
        bind(Identity.class).to(IdentityImpl.class).in(Scopes.SINGLETON);
        bind(Printer.class).to(PrinterImpl.class).in(Scopes.SINGLETON);
        bind(PrinterProperties.class).to(PrinterPropertiesImpl.class).in(Scopes.SINGLETON);
        bind(Security.class).to(SecurityImpl.class).in(Scopes.SINGLETON);
        bind(InvoicePrinter.class).annotatedWith(Names.named("invoicePrinter"))
                .to(InvoicePrinterImpl.class).in(Scopes.SINGLETON);
        bind(InvoicePrinter.class).annotatedWith(Names.named("securedInvoicePrinter"))
                .to(SecuredInvoicePrinterImpl.class).in(Scopes.SINGLETON);

        MapBinder<String, InvoiceGenerator> invoiceGeneratorMapBinder =
                MapBinder.newMapBinder(binder(), String.class, InvoiceGenerator.class);
        invoiceGeneratorMapBinder.addBinding("print")
                .to(InvoicePrintGenerator.class).in(Scopes.SINGLETON);
        invoiceGeneratorMapBinder.addBinding("email")
                .to(InvoiceEmailGenerator.class).in(Scopes.SINGLETON);
    }

    @Provides
    @Singleton
    public PrinterManager getPrinterManager() {
        PrinterManagerImpl printerManager = new PrinterManagerImpl();
        printerManager.initialize();
        return printerManager;
    }
}
