// tag::beginAnnotation[]
package com.marcobehler.myfancypdfinvoices.springboot.web;


import com.marcobehler.myfancypdfinvoices.springboot.dto.InvoiceDto;
import com.marcobehler.myfancypdfinvoices.springboot.model.Invoice;
import com.marcobehler.myfancypdfinvoices.springboot.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

// tag::restControllerAnnotation[]
@RestController
public class InvoicesController {
// end::restControllerAnnotation[]
// end::beginAnnotation[]

    // tag::invoiceServiceInjection[]
    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
    // end::invoiceServiceInjection[]

    // tag::invoiceMethod[]
    @GetMapping("/invoices")
    public Iterable<Invoice> invoices() {

        return invoiceService.findAll();
    }
    // end::invoiceMethod[]

    @GetMapping("/invoices/user/{userId}")
    public Iterable<Invoice> invoices(@PathVariable String userId) {
        return invoiceService.findByUserId(userId);
    }

    // tag::createInvoiceMethod[]
    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
    // end::createInvoiceMethod[]
}
