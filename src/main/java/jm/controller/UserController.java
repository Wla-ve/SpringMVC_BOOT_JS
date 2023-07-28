package jm.controller;

import jm.model.User;
import jm.service.RoleService;
import jm.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String userInfo(@AuthenticationPrincipal User user, ModelMap model) {
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRoles());
        return "user-page";
    }

    @GetMapping("/admin")
    public String adminInfo(@AuthenticationPrincipal User user, ModelMap model) {
        model.addAttribute("user", user);
        model.addAttribute("allRoles",roleService.findAll());
        model.addAttribute("allUsers", userService.findAll());
        return "admin-page";
    }
}
