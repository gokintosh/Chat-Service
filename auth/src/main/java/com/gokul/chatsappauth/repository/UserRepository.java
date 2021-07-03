package com.gokul.chatsappauth.repository;

import com.gokul.chatsappauth.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);



}
