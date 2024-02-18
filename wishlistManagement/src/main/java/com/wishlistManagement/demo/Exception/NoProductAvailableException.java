package com.wishlistManagement.demo.Exception;

public class NoProductAvailableException extends RuntimeException {

    public NoProductAvailableException(String message) {
        super(message);
    }
}
