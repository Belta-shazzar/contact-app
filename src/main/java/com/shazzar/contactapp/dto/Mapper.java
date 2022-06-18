package com.shazzar.contactapp.dto;

import com.shazzar.contactapp.dto.responseDto.ContactResponseDto;
import com.shazzar.contactapp.dto.responseDto.UserResponseDto;
import com.shazzar.contactapp.entity.Contact;
import com.shazzar.contactapp.entity.User;
import com.shazzar.contactapp.repository.ContactRepository;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mapper {

    public static UserResponseDto userToUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUsername(user.getUserName());
        userResponseDto.setMobileNumber(user.getMobileNumber());
        return userResponseDto;
    }

    public static ContactResponseDto contactToContactDto(Contact contact) {
        ContactResponseDto contactResponseDto = new ContactResponseDto();
        contactResponseDto.setName(contact.getContactName());
        contactResponseDto.setMobile(contact.getMobileNumber());

        return contactResponseDto;
    }

    public static List<ContactResponseDto> contactToContactDtos(List<Contact> contacts) {
        List<ContactResponseDto> contactResponseDtoList = new ArrayList<>();

        for (Contact contact : contacts) {
            contactResponseDtoList.add(contactToContactDto(contact));
        }
        return contactResponseDtoList;
    }
}
