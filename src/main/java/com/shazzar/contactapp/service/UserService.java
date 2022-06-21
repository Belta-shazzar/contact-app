package com.shazzar.contactapp.service;

import com.shazzar.contactapp.entity.User;

public interface UserService {
    User addUser(User user);
    User getById(long id);
    User getByMobile(String number, String password);
    User deleteUserContact(long userId, long contactId);

}
