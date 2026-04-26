package ro.mycode.sebionlineshop.categories.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class CategoryAlreadyexistsException extends RuntimeException {
    public CategoryAlreadyexistsException() {
        super(ErrorConstants.CATEGORY_ALREADY_EXISTS_EXCEPTION);
    }
}
