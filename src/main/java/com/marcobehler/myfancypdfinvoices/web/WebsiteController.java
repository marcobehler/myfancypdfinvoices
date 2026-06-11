package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.web.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class WebsiteController {

    // tag::homePageMethodDescription[]
    @GetMapping("/")
    public String homepage(Model model, @RequestParam(required = false, defaultValue = "stranger") String username) {
        // end::homePageMethodDescription[]
        // tag::modelAttributes[]
        model.addAttribute("username", username);
        model.addAttribute("currentDate", LocalDateTime.now());
        // end::modelAttributes[]
        return "index.html";
    }

    // tag::loginMethodDescription[]
    @GetMapping("/login")
    public String login(Model model){
        // end::loginMethodDescription[]
        // tag::loginModelAttributes[]
        model.addAttribute("loginForm", new LoginForm());
        // end::loginModelAttributes[]
        return "login.html";
    }
}
