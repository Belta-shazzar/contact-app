package com.shazzar.contactapp.dto.requestDto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String userName;
    private String mobileNumber;
    private String password;
    private String passwordVerify;
}
