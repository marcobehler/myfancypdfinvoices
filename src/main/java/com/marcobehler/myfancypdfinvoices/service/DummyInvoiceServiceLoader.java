package com.marcobehler.myfancypdfinvoices.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

// tag::serviceAnnotation[]
@Service
// end::serviceAnnotation[]
// tag::profileAnnotation[]
@Profile("dev")
// end::profileAnnotation[]
public class DummyInvoiceServiceLoader {

    // tag::constructorDi[]
    private final InvoiceService invoiceService;

    public DummyInvoiceServiceLoader(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    // end::constructorDi[]

    // tag::setup[]
    @PostConstruct
    public void setup() {
        System.out.println("Creating dev invoices...");
        invoiceService.create("someUserId", 50);
        invoiceService.create("someOtherUserId", 100);
    }
    // end::setup[]
}
