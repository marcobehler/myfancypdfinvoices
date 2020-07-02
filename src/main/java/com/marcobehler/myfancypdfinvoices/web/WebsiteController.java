package com.marcobehler.myfancypdfinvoices.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {

    // tag::homePageMethodDescription[]
    @GetMapping("/")
    public String homepage() {
        // end::homePageMethodDescription[]
        // tag::templateReturn[]
        return "index.html";
        // end::templateReturn[]
    }
}
