package com.marcobehler.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcobehler.myfancypdfinvoices.ApplicationLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties"
                    , ignoreResourceNotFound = true)
// tag::enableWebMVCAnnotation[]
@EnableWebMvc
public class ApplicationConfiguration {
// end::enableWebMVCAnnotation[]

    // tag::methodValidationPostProcessor[]
    @Bean // <1>
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
    // end::methodValidationPostProcessor[]


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    // tag::viewResolver[]
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());

        viewResolver.setOrder(1); // optional
        viewResolver.setViewNames(new String[] {"*.html", "*.xhtml"}); // optional
        return viewResolver;
    }
    // end::viewResolver[]

    // tag::templateEngine[]
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
    // end::templateEngine[]

    // tag::templateResolver[]
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    // end::templateResolver[]
}
