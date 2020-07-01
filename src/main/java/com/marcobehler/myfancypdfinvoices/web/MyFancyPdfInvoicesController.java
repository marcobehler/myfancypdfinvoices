package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import com.marcobehler.myfancypdfinvoices.dto.InvoiceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    @PostMapping("/invoices")
    // end::postAnnotation[]
    // tag::postMethodSignature[]
    public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
    // end::postMethodSignature[]
    // tag::postDelegate[]
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    // end::postDelegate[]
    }
}
