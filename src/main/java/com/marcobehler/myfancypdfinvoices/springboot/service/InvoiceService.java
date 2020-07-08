package com.marcobehler.myfancypdfinvoices.springboot.service;


import com.marcobehler.myfancypdfinvoices.springboot.model.Invoice;
import com.marcobehler.myfancypdfinvoices.springboot.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    private final UserService userService;

    private final String cdnUrl;

    // tag::jdbcTemplateConstructor[]
    public InvoiceService(UserService userService, InvoiceRepository invoiceRepository, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
        this.invoiceRepository = invoiceRepository;
    }
    // end::jdbcTemplateConstructor[]

    // tag::postConstruct[]
    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }
    // end::postConstruct[]

    // tag::preDestroy[]
    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }
    // end::preDestroy[]

    // tag::findAllMethod[]
    @Transactional
    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }
    // end::findAllMethod[]

    // tag::createMethod[]
    @Transactional
    public Invoice create(String userId, Integer amount) {
        String generatedPdfUrl = cdnUrl + "/images/default/sample.pdf";

        Invoice invoice = new Invoice();
        invoice.setPdfUrl(generatedPdfUrl);
        invoice.setAmount(amount);
        invoice.setUserId(userId);

        return invoiceRepository.save(invoice);
    }
    // end::createMethod[]
}
