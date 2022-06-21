package com.shazzar.contactapp.service;

import com.shazzar.contactapp.dto.requestDto.ContactRequestDto;
import com.shazzar.contactapp.entity.Contact;

public interface ContactService {
   Contact getById(long contactId);
   Contact addContact(ContactRequestDto contactRequestDto);
   void deleteContact(long contactId);

}
