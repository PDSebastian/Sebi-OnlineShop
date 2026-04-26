package ro.mycode.sebionlineshop.productCategories.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class ProductCategoryAlreadyExistsException extends RuntimeException {
    public ProductCategoryAlreadyExistsException() {
        super(ErrorConstants.PRODUCTCATEGORY_ALREADY_EXISTS_EXCEPTION);
    }
}
