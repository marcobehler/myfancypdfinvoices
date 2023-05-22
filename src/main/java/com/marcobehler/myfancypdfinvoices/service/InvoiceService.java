package com.marcobehler.myfancypdfinvoices.service;


import com.marcobehler.myfancypdfinvoices.model.Invoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

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

    // tag::findAllMethodHeaderTx[]
    @Transactional
    public List<Invoice> findAll() {
        System.out.println("Is a database transaction open? = " + TransactionSynchronizationManager.isActualTransactionActive());
    // end::findAllMethodHeaderTx[]
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

    // tag::createMethodHeaderTx[]
    @Transactional
    public Invoice create(String userId, Integer amount) {
        System.out.println("Is a database transaction open? = " + TransactionSynchronizationManager.isActualTransactionActive());
    // end::createMethodHeaderTx[]
        // tag::createStaticPdfUrl[]
        String generatedPdfUrl = cdnUrl + "/images/default/sample.pdf";
        // end::createStaticPdfUrl[]

        // tag::createKeyholder[]
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // end::createKeyholder[]

        // tag::jdbcTemplateUpdate[]
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("insert into invoices (user_id, pdf_url, amount) values (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userId);  // <3>
            ps.setString(2, generatedPdfUrl);
            ps.setInt(3, amount);
            return ps;
        }, keyHolder);
        // end::jdbcTemplateUpdate[]

        // tag::uuid[]
        String uuid = !keyHolder.getKeys().isEmpty() ? ((UUID) keyHolder.getKeys().values().iterator().next()).toString()
                : null;
        // end::uuid[]

        // tag::invoicePojo[]
        Invoice invoice = new Invoice();
        invoice.setId(uuid);
        invoice.setPdfUrl(generatedPdfUrl);
        invoice.setAmount(amount);
        invoice.setUserId(userId);
        return invoice;
        // end::invoicePojo[]
    }
    // end::createMethod[]
}
