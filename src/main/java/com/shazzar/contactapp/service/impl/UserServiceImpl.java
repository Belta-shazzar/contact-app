package com.shazzar.contactapp.service.impl;

import com.shazzar.contactapp.dto.Mapper;
import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.entity.Contact;
import com.shazzar.contactapp.entity.User;
import com.shazzar.contactapp.repository.UserRepository;
import com.shazzar.contactapp.service.ContactService;
import com.shazzar.contactapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ContactService contactService;

    public UserServiceImpl(UserRepository userRepository, ContactService contactService) {
        this.userRepository = userRepository;
        this.contactService = contactService;
    }

    @Override
    public User addUser(User user) {
        if (!user.getPassword().equals(user.getPasswordVerify())) {
            throw new IllegalArgumentException("Password does not match");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User does not exist"));
    }

    @Override
    public List<ContactResponseDto> getUserContact(long id) {
//        Get user, and return list of user's contact
        User user = getById(id);
        List<Contact> contacts = user.getContact();
        return Mapper.contactToContactDtos(contacts);
    }

    @Override
    public ContactResponseDto getContactById(long userId, long contactId) {
        User user = getById(userId);
//        Risky code
        Contact savedContact = contactService.getById(contactId);
        for (Contact contact : user.getContact()) {
            if (contact.getId().equals(contactId)) {
                savedContact = contact;
            }
        }
        return Mapper.contactToContactDto(savedContact);
    }

//    Fix error handling problem later
    @Override
    public User getByMobile(String number, String password) {
        User user = Optional.ofNullable(userRepository.findByMobileNumber(number))
                .orElseThrow(() -> new IllegalArgumentException("Mobile number does not exist"));
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Wrong password");
        }
        return user;
    }


}
