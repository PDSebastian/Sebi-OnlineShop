package ro.mycode.sebionlineshop.options.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class OptionAlreadyExistsException extends RuntimeException {
    public OptionAlreadyExistsException() {
        super(ErrorConstants.CATEGORY_ALREADY_EXISTS_EXCEPTION);
    }
}
