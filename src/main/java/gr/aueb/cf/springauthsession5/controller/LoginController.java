package gr.aueb.cf.springauthsession5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Principal principal) {
        return principal == null ? "login" : "redirect:/dashboard";
    }

    @GetMapping("/")
    public String root(Principal principal) {
        //return "redirect:/login";
        return principal == null ? "login" : "redirect:/dashboard";
    }
}
