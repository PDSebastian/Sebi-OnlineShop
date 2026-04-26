package ro.mycode.sebionlineshop.productOptions.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class ProductOptionAlreadyExistsException extends RuntimeException {
    public ProductOptionAlreadyExistsException() {
        super(ErrorConstants.ProductOptionALREADY_EXISTS_EXCEPTION);
    }
}
