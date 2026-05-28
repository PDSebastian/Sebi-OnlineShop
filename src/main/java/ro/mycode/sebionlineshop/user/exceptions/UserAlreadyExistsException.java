package ro.mycode.sebionlineshop.user.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException( ) {
        super(ErrorConstants.USER_ALREADY_EXISTS_EXCEPTION);
    }
}
