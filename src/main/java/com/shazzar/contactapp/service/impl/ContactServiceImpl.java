package com.shazzar.contactapp.service.impl;

import com.shazzar.contactapp.dto.requestDto.ContactRequestDto;
import com.shazzar.contactapp.entity.Contact;
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
    public Contact getById(long contactId) {
        return contactRepo.findById(contactId).orElseThrow(() ->
                new IllegalArgumentException("Contact does not exist"));
    }

    @Override
    public Contact addContact(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        contact.setContactName(contactRequestDto.getContactName());
        contact.setMobileNumber(contactRequestDto.getMobileNumber());
        contact.setUser(userService.getById(contactRequestDto.getUserId()));

        return contactRepo.save(contact);
    }

    @Override
    public void deleteContact(long contactId) {
        Contact contact = getById(contactId);
        contactRepo.delete(contact);
    }
}
