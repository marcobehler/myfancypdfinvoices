package com.marcobehler.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import com.marcobehler.myfancypdfinvoices.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyFancyPdfInvoicesApplicationConfiguration {

    // tag::userServiceMethod[]
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
