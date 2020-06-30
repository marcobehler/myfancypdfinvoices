package com.marcobehler.myfancypdfinvoices.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// tag::classAnnotations[]
@Controller
@ResponseBody
public class MyFirstSpringController {
// end:classAnnotations[]

    // tag::getMapping[]
    @GetMapping("/")
    // end::getMapping[]
    // tag::indexMethod[]
    public String index() {
        return "Hello World";
    }
    // end::indexMethod[]
}
