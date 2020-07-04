package com.marcobehler.myfancypdfinvoices.service;


import com.marcobehler.myfancypdfinvoices.model.Invoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class InvoiceService {

    private final JdbcTemplate jdbcTemplate;

    private final UserService userService;

    private final String cdnUrl;

    // tag::jdbcTemplateConstructor[]
    public InvoiceService(UserService userService, JdbcTemplate jdbcTemplate, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
        this.jdbcTemplate = jdbcTemplate;
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
    public List<Invoice> findAll() {
        return jdbcTemplate.query("select id, user_id, pdf_url, amount from invoices", (resultSet, rowNum) -> {
            Invoice invoice = new Invoice();
            invoice.setId(resultSet.getObject("id").toString());
            invoice.setPdfUrl(resultSet.getString("pdf_url"));
            invoice.setUserId(resultSet.getString("user_id"));
            invoice.setAmount(resultSet.getInt("amount"));
            return invoice;
        });
    }
    // end::findAllMethod[]

    // tag::createMethod[]
    public Invoice create(String userId, Integer amount) {
        throw new IllegalStateException("not yet implemented");
    }
    // end::createMethod[]
}
