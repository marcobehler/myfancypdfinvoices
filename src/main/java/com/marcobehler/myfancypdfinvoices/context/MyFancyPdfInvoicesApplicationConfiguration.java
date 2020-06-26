package com.marcobehler.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcobehler.myfancypdfinvoices.ApplicationLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// tag::componentScanAnnotation[]
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
public class MyFancyPdfInvoicesApplicationConfiguration {
// end::componentScanAnnotation[]

    // tag::objectMapperMethod[]
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    // end::objectMapperMethod[]
}
