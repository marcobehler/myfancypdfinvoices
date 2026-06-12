// tag::beginAnnotation[]
package com.marcobehler.myfancypdfinvoices.springboot.web;


import com.marcobehler.myfancypdfinvoices.springboot.dto.InvoiceDto;
import com.marcobehler.myfancypdfinvoices.springboot.model.Invoice;
import com.marcobehler.myfancypdfinvoices.springboot.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

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

    // tag::getAnnotation[]
    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    // tag::invoiceMethod[]
    public List<Invoice> invoices() {
        // end::getAnnotation[]
        return invoiceService.findAll();
    }
    // end::invoiceMethod[]

    // tag::createInvoiceMethod[]
    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
    // end::createInvoiceMethod[]
}
