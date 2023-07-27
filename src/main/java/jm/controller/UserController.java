package jm.controller;

import jm.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userInfo(@AuthenticationPrincipal User user, ModelMap model){
        model.addAttribute("user",user);
        model.addAttribute("role",user.getRoles());
        return "user-page";
    }
}
