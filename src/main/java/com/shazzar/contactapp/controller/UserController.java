package com.shazzar.contactapp.controller;

import com.shazzar.contactapp.entity.User;
import com.shazzar.contactapp.service.ContactService;
import com.shazzar.contactapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    public final UserService userService;
    public final ContactService contactService;


    public UserController(UserService userService, ContactService contactService) {
        this.userService = userService;
        this.contactService = contactService;
    }

    @GetMapping("/newUser")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create-user";
    }

    @PostMapping("/new-user")
    public String saveUser(@Valid @ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user/get-contacts/" + user.getId();
    }

    @GetMapping("/get-contacts/{userId}")
    public String getContacts(Model model, @PathVariable("userId") long userId) {
        model.addAttribute("contacts", userService.getUserContact(userId));
        return "display";
    }
}
