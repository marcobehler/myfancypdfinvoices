package com.marcobehler.myfancypdfinvoices.springboot.repository;

import com.marcobehler.myfancypdfinvoices.springboot.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {
}
