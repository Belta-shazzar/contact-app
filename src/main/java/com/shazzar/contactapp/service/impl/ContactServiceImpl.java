package com.shazzar.contactapp.service.impl;

import com.shazzar.contactapp.dto.Mapper;
import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.entity.Contact;
import com.shazzar.contactapp.entity.User;
import com.shazzar.contactapp.repository.ContactRepository;
import com.shazzar.contactapp.service.ContactService;
import com.shazzar.contactapp.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepo;
    private final UserService userService;

    @Lazy
    public ContactServiceImpl(ContactRepository contactRepo, UserService userService) {
        this.contactRepo = contactRepo;
        this.userService = userService;
    }

    @Override
    public ContactResponseDto addContact(Contact contact, long userId) {
        User user = userService.getById(userId);
//        Checks if user actually exist, before saving the contact
        if (user != null) {
            contact.setUser(user);
            contactRepo.save(contact);
        }
        return Mapper.contactToContactDto(contact);
    }

    @Override
    public Contact getById(long contactId) {
        return contactRepo.findById(contactId).orElseThrow(() ->
                new IllegalArgumentException("Contact does not exist"));
    }
}
