package com.shazzar.contactapp.service;

import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.entity.Contact;

import java.util.List;

public interface ContactService {
   List<ContactResponseDto> getContacts(long id);
   ContactResponseDto addContact(Contact contact, long userId);
}
