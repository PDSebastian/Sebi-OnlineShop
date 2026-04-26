package ro.mycode.sebionlineshop.products.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super(ErrorConstants.PRODUCT_NOT_FOUND_EXCEPTION);
    }
}
