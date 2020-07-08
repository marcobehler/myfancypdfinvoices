package com.marcobehler.myfancypdfinvoices.springboot.repository;

import com.marcobehler.myfancypdfinvoices.springboot.model.Invoice;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {

    // tag::queryAnnotation[]
    @Query("SELECT id, pdf_url, user_id, amount FROM invoices where user_id = :userId")
    // end::queryAnnotation[]
    // tag::method[]
    Iterable<Invoice> findByUserId(@Param("userId") String userId);
    // end::method[]
}
