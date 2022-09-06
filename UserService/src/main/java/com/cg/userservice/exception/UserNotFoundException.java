package com.cg.userservice.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message) {
        super(message);
    }
		
	}



