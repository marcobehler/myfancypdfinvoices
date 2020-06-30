package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// tag::restControllerAnnotation[]
@RestController
public class MyFancyPdfInvoicesController {
// end::restControllerAnnotation[]

    // tag::invoiceServiceInjection[]
    private final InvoiceService invoiceService;

    public MyFancyPdfInvoicesController(InvoiceService invoiceService) {
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

    // tag::postAnnotation[]
    @PostMapping("/invoices/{userId}/{amount}")
    // end::postAnnotation[]
    // tag::postMethodSignature[]
    public Invoice createInvoice(@PathVariable String userId, @PathVariable Integer amount) {
    // end::postMethodSignature[]
    // tag::postDelegate[]
        return invoiceService.create(userId, amount);
    // end::postDelegate[]
    }
}
