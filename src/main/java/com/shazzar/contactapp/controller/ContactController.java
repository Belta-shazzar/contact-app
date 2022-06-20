package com.shazzar.contactapp.controller;

import com.shazzar.contactapp.dto.requestDto.ContactRequestDto;
import com.shazzar.contactapp.entity.Contact;
import com.shazzar.contactapp.service.ContactService;
import com.shazzar.contactapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/newContact")
    public String addContactForm(Model model) {
        ContactRequestDto contact = new ContactRequestDto();
        model.addAttribute("contact", contact);
        return "addContact";
    }

//    Action link points here
    @PostMapping("/add-contact/{userId}")
    public String addContact(@Valid @ModelAttribute("contact")Contact contact,
                             @PathVariable("userId") long userId) {
        contactService.addContact(contact, userId);
        return "redirect:/user/get-contacts/" + userId;
    }






}



