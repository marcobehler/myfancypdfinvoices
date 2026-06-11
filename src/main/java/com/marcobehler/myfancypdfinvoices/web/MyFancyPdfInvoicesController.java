// tag::beginAnnotation[]
package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

// tag::restControllerAnnotation[]
@RestController
@Validated
public class MyFancyPdfInvoicesController {
// end::restControllerAnnotation[]
// end::beginAnnotation[]

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
