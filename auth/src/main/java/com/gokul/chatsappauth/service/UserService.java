package com.gokul.chatsappauth.service;


import com.gokul.chatsappauth.entity.Role;
import com.gokul.chatsappauth.entity.User;
import com.gokul.chatsappauth.exception.UsernameAlreadyExistsException;
import com.gokul.chatsappauth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;




    public User registerUser(User user, Role role){
        log.info("Creating user {}",user.getUsername());

        if(userRepository.existsByUsername(user.getUsername())){
            log.warn("Username {} already exists!!",user.getUsername());

            throw new UsernameAlreadyExistsException(
                    String.format("Username %s already exists!!",user.getUsername())
            );
        }

        if(userRepository.existsByEmail(user.getEmail())){
            log.warn("email {} already exists!!",user.getEmail());

            throw new UsernameAlreadyExistsException(
                    String.format("Email %s already exists!!",user.getEmail())
            );
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(){{add(role);}});

        return userRepository.save(user);

    }
}
