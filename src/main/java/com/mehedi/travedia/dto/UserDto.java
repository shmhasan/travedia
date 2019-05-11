package com.mehedi.travedia.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 15)
    private String username;

    @NotEmpty
    @NotNull
    @Size(min = 3)
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 20)
    private String password;

    private String firstname;

    private String lastname;


}
