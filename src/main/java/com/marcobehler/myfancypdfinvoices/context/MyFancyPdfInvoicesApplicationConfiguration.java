package com.marcobehler.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import com.marcobehler.myfancypdfinvoices.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFancyPdfInvoicesApplicationConfiguration {

    // tag::userServiceMethod[]
    @Bean
    public UserService userService() {
        return new UserService();
    }
    // end::userServiceMethod[]

    // tag::invoiceServiceMethod[]
    @Bean
    public InvoiceService invoiceService(UserService userService) {
        return new InvoiceService(userService);
    }
    // end::invoiceServiceMethod[]

    // tag::objectMapperMethod[]
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    // end::objectMapperMethod[]
}
