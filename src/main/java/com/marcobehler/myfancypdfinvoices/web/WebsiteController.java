package com.marcobehler.myfancypdfinvoices.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class WebsiteController {

    // tag::homePageMethodDescription[]
    @GetMapping("/")
    public String homepage(Model model, @RequestParam(required = false) String username) {
        // end::homePageMethodDescription[]
        // tag::modelAttributes[]
        model.addAttribute("username", username == null ? username : "stranger");
        model.addAttribute("currentDate", new Date());
        // end::modelAttributes[]
        return "index.html";
    }
}
