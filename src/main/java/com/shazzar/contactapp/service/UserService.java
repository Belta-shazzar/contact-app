package com.shazzar.contactapp.service;

import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getById(long id);
    List<ContactResponseDto> getUserContact(long id);

}
