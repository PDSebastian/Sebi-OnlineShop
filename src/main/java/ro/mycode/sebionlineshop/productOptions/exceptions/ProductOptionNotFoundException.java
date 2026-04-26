package ro.mycode.sebionlineshop.productOptions.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class ProductOptionNotFoundException extends RuntimeException {
    public ProductOptionNotFoundException() {
        super(ErrorConstants.ProductOptionNOT_FOUND_EXCEPTION);
    }
}
