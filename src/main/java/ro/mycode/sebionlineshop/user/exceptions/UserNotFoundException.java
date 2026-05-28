package ro.mycode.sebionlineshop.user.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ErrorConstants.USER_NOT_FOUND_EXCEPTION);
    }
}
