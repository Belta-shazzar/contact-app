package com.shazzar.contactapp.service;

import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.entity.Contact;

public interface ContactService {
   ContactResponseDto addContact(Contact contact, long userId);
   Contact getById(long contactId);
}
