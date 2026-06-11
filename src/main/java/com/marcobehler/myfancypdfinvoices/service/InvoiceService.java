package com.marcobehler.myfancypdfinvoices.service;


import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private List<Invoice> invoices = new CopyOnWriteArrayList<>();

    private final UserService userService;
    // tag::cdnUrlConstructor[]
    private final String cdnUrl;

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }
    // end::cdnUrlConstructor[]

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

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        // tag::cdnUrlUsed[]
        // TODO real pdf creation and storing it on network server
        Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
        // end::cdnUrlUsed[]
    }
}
