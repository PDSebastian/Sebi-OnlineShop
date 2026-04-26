package ro.mycode.sebionlineshop.options.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class OptionNotFoundException extends RuntimeException {
    public OptionNotFoundException() {
        super(ErrorConstants.OPTION_NOT_FOUND_EXCEPTION);
    }
}
