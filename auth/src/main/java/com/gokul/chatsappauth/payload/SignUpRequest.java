package com.gokul.chatsappauth.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 3,max = 50)
    private String name;


    @NotBlank
    @Size(min=3,max = 15)
    private String username;


    @NotBlank
    @Email
    @Size(max = 40)
    private String email;

    @NotBlank
    @Size(min = 8,max = 50)
    private String password;

    @NotBlank
    private String profilePicUrl;


}
