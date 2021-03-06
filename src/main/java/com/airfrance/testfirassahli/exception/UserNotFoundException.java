package com.airfrance.testfirassahli.exception;

/**
 * Custom exception for not found User
 *
 * @author firas.sahli
 */
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
