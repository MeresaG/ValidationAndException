package edu.miu.validationAndexception.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super();
    }
    public UserNotFoundException(String msg) {
        super(msg);
    }

}
