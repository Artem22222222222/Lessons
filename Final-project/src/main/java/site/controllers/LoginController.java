package site.controllers;

import DataBases.SiteBase;
import Exceptions.SQLEConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

@Controller
public class LoginController {
    String answer = "";
    String[] s;
    String email;
    SiteBase base = new SiteBase();
    @GetMapping("/login")
    public String pageLogin(){
        return "login";
    }
    @PostMapping("/email")
    public String login(@RequestBody String login, Model model) {
        s = login.split("=");
         email = s[1];
         try {
             answer = base.findAccountsByEmail(email);
         }catch (SQLEConnectionException e){
             answer = e.getMessage();
         }


        model.addAttribute("answer", answer);

        return "account";
    }
}
