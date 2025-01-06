package site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    SiteController siteController = new SiteController();
    String[] joke = {"", ""};
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/Jokes")
    public String myPage(Model model) {
        joke = siteController.joke();
        model.addAttribute("jokeSetup", joke[0]);
        model.addAttribute("jokePunchline", joke[1]);
        return "myPage";
    }
}
