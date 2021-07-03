package com.gokul.chatsappauth.exception;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
