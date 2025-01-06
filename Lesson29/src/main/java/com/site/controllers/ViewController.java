package com.site.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {
    Contoller contoller = new Contoller();
    String[] joke = {"", ""};
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/Jokes")
    public String myPage(Model model) {
        joke = contoller.joke();
        model.addAttribute("jokeSetup", joke[0]);
        model.addAttribute("jokePunchline", joke[1]);
        return "myPage";
    }
}
