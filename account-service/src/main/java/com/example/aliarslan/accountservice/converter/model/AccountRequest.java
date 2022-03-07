package com.example.aliarslan.accountservice.converter.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AccountRequest {

    @NotBlank(message = "username is mandatory")
    String username;

    @NotBlank(message = "mail is mandatory")
    @Email(message = "mail address is not valid")
    String mailAddress;

    @NotBlank(message = "password is mandatory")
    String password;
}
