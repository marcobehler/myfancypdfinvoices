package com.marcobehler.myfancypdfinvoices.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MyFirstSpringController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }
}
