package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.web.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    // tag::loginPostMethodDescription[]
    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, Model model){
        // end::loginPostMethodDescription[]
        // tag::loginPostModelAttributes[]
        if (loginForm.getUsername().equals(loginForm.getPassword())) {
            return "redirect:/";
        }
        // end::loginPostModelAttributes[]
        // tag::loginPostReturn[]
        model.addAttribute("invalidCredentials", "true");
        return "login.html";
        // tag::loginPostReturn[]
    }
}
