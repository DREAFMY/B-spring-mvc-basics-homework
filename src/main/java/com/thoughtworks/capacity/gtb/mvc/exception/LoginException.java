package com.thoughtworks.capacity.gtb.mvc.exception;

public class LoginException extends Error{
    @Override
    public String getMessage() {
        return "user name or password error";
    }
}
