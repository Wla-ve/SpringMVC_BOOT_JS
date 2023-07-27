package jm.controller;

import jm.model.Role;
import jm.model.User;
import jm.service.RoleService;
import jm.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    public AdminController(UserService userService,RoleService roleService){
        this.userService=userService;
        this.roleService=roleService;

    }
    @GetMapping
    public String getAll(@AuthenticationPrincipal User user, ModelMap model){
        model.addAttribute("user",user);
        model.addAttribute("allRoles",roleService.findAll());
        model.addAttribute("allUsers",userService.findAll());
        return "admin-page";
    }
    @GetMapping("/new")
    public String newUser(ModelMap model){
        model.addAttribute("user",new User());
        model.addAttribute("roles",roleService.findAll());
        return "new";
    }
    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : checkBoxRoles) {
            roleSet.add(roleService.findByName(role));
        }
        user.setRoles(roleSet);
        userService.save(user);
        return "redirect:/admin";
    }
    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : checkBoxRoles) {
            roleSet.add(roleService.findByName(roles));
        }
        user.setRoles(roleSet);
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}/delete")
    public String removeUser(@PathVariable("id") long id) {
        System.out.println(id);
        userService.deleteById(id);
        return "redirect:/admin";
    }
}
