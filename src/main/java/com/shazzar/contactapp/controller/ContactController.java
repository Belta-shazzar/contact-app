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

    @GetMapping("/newContact/{userId}")
    public String addContactForm(Model model, @PathVariable("userId") long userId) {
        ContactRequestDto contact = new ContactRequestDto();
        contact.setUserId(userId);
        model.addAttribute("contact", contact);
        return "addContact";
    }

//    Action link points here
    @PostMapping("/add-contact")
    public String addContact(@Valid @ModelAttribute("contact")ContactRequestDto contact) {
        contactService.addContact(contact);
        return "redirect:/user/get-contacts/" + contact.getUserId();
    }






}



