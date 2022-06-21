package com.shazzar.contactapp.dto.requestDto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContactRequestDto {

    @NotNull(message = "field cannot be blank")
    @Size(min = 3, max = 15)
    private String contactName;

//    @Pattern()
    @NotBlank(message = "field cannot be blank")
    private String mobileNumber;


    private Long userId;
}
