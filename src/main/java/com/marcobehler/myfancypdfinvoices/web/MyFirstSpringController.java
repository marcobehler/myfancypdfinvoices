package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// tag:restControllerAnnotation[]
@RestController
public class MyFirstSpringController {
// end:restControllerAnnotation[]

    // tag:invoiceServiceInjection[]
    @Autowired
    private InvoiceService invoiceService;
    // end:invoiceServiceInjection[]

    // tag:getMethod[]
    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }
    // end:getMethod[]
}
