package com.shazzar.contactapp.service.impl;

import com.shazzar.contactapp.dto.Mapper;
import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.entity.Contact;
import com.shazzar.contactapp.entity.User;
import com.shazzar.contactapp.repository.ContactRepository;
import com.shazzar.contactapp.service.ContactService;
import com.shazzar.contactapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepo;
    private final UserService userService;

    public ContactServiceImpl(ContactRepository contactRepo, UserService userService) {
        this.contactRepo = contactRepo;
        this.userService = userService;
    }

    @Override
    public List<ContactResponseDto> getContacts(long id) {

        List<Contact> contacts = contactRepo.findAll();

        return Mapper.contactToContactDtos(contacts);
    }

    @Override
    public ContactResponseDto addContact(Contact contact, long userId) {
        User user = userService.getById(userId);
        if (user != null) {
            contact.setUser(user);
            contactRepo.save(contact);
        }
        return Mapper.contactToContactDto(contact);
    }
}
