package ro.mycode.sebionlineshop.productCategories.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class ProductCategoryNotFoundException extends RuntimeException {
    public ProductCategoryNotFoundException() {
        super(ErrorConstants.PRODUCTCATEGORY_NOT_FOUND_EXCEPTION);
    }
}
