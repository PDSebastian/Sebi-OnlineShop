package ro.mycode.sebionlineshop.products.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException() {
        super(ErrorConstants.PRODUCT_ALREADY_EXISTS_EXCEPTION);
    }
}
