package com.gokul.chatsappauth.controller;


import com.gokul.chatsappauth.entity.Profile;
import com.gokul.chatsappauth.entity.Role;
import com.gokul.chatsappauth.entity.User;
import com.gokul.chatsappauth.exception.BadRequestException;
import com.gokul.chatsappauth.exception.EmailAlreadyExistsException;
import com.gokul.chatsappauth.exception.UsernameAlreadyExistsException;
import com.gokul.chatsappauth.payload.ApiResponse;
import com.gokul.chatsappauth.payload.SignUpRequest;
import com.gokul.chatsappauth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Slf4j
public class AuthEndpoint {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>createUser(@Valid @RequestBody SignUpRequest signUpRequest){

        log.info("Creating user with username {}",signUpRequest.getUsername());

        User user=User.builder().username(signUpRequest.getUsername()).email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword()).userProfile(Profile.builder().displayName(signUpRequest.getName())
                        .profilePictureUrl(signUpRequest.getProfilePicUrl()).build()).build();

        try{
            userService.registerUser(user, Role.User);
        }catch(UsernameAlreadyExistsException| EmailAlreadyExistsException e){
            throw new BadRequestException(e.getMessage());
        }

        URI location= ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(user.getUsername()).toUri();


        return ResponseEntity.created(location)
                .body(new ApiResponse(true,"User registered successfully"));



    }
}
