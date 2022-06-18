package com.shazzar.contactapp.controller;

import com.shazzar.contactapp.dto.requestDto.ContactRequestDto;
import com.shazzar.contactapp.service.ContactService;
import com.shazzar.contactapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;
    private final UserService userService;

    public ContactController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

//    @GetMapping("/get-all")
//    public String getContacts(Model model) {
////        model.addAttribute("contacts", contactService.getContacts());
//        return "display";
//    }

    @GetMapping("/new")
    public String addContactForm(Model model) {
        ContactRequestDto contact = new ContactRequestDto();
        model.addAttribute("contact", contact);
        return "addContact";
    }

//    @PostMapping("/add-contact")
//    public String saveContact(@ModelAttribute("contact") ContactRequestDto contactRequestDto) {
//
//    }




}



