package com.yasan.exceptions;

/**
 * Created by Maryam.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
