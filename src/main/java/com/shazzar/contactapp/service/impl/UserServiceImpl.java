package com.shazzar.contactapp.service.impl;

import com.shazzar.contactapp.dto.Mapper;
import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.entity.Contact;
import com.shazzar.contactapp.entity.User;
import com.shazzar.contactapp.repository.UserRepository;
import com.shazzar.contactapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        User user = getById(id);
        List<Contact> contacts = user.getContact();
        return Mapper.contactToContactDtos(contacts);
    }


}
