package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import com.marcobehler.myfancypdfinvoices.dto.InvoiceDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    // tag::createInvoiceMethod[]
    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId, @RequestParam @Min(10) @Max(50) Integer amount) {
        return invoiceService.create(userId, amount);
    }
    // end::createInvoiceMethod[]
}
