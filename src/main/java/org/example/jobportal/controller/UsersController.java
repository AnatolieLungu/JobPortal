package org.example.jobportal.controller;


import jakarta.validation.Valid;
import org.example.jobportal.entities.Users;
import org.example.jobportal.entities.UsersType;
import org.example.jobportal.services.UsersService;
import org.example.jobportal.services.UsersTypeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {
private final UsersTypeServices usersTypeServices;
private final UsersService usersService;

    public UsersController(UsersTypeServices usersTypeServices, UsersService usersService) {
        this.usersTypeServices = usersTypeServices;
        this.usersService = usersService;
    }
    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeServices.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("users", new Users());
        return "register";
    }
    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users,Model model) {
        Optional<Users> optionalUsers = usersService.getUserByEmail(users.getEmail());

        if (optionalUsers.isPresent()) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }
        usersService.addNewUser(users);
        return "dashboard";
    }

}
