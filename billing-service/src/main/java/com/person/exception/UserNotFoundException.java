package com.person.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String login) {
        super("Could not find user with login = " + login);
    }
}
