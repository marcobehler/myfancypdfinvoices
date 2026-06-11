package com.marcobehler.myfancypdfinvoices.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// tag::classAnnotations[]
@Controller
public class MyFirstSpringController {
// end::classAnnotations[]

    // tag::getMapping[]
    @GetMapping("/")
    @ResponseBody
    // tag::indexMethod[]
    public String index() {
    // end::getMapping[]
        return "Hello World";
    }
    // end::indexMethod[]
}
