package com.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Random;

@Controller
public class NumberController {
    Random random = new Random();
    int a = random.nextInt(101);
    String answer = "";
    @GetMapping("/number")
    public String number(){
        return "number";
    }
    @PostMapping("/number")
    public String attempt(@RequestBody String attempt, Model model){
        String[] s = attempt.split("=");
        int number = Integer.parseInt(s[1]);
        if (number == a){
            return "win";
        }else if (a < number){
            answer = "too much";
        }else if (a > number){
            answer = "too little";
        }
        model.addAttribute("answer", answer);
        return "number";
    }
}
