package com.yasan.exceptions;

/**
 * Created by pooya on 1/13/17.
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException(String s) {
        super(s);
    }
}
