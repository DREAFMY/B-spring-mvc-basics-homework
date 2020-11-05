package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserExistException extends Error {
    @Override
    public String getMessage() {
        return "user is already exit";
    }
}
