package ro.mycode.sebionlineshop.categories.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super(ErrorConstants.CATEGORY_NOT_FOUND_EXCEPTION);
    }
}
