package ro.mycode.sebionlineshop.productCategories.exceptions;

public class ProductCategoryAlreadyExistsException extends RuntimeException {
    public ProductCategoryAlreadyExistsException(String message) {
        super(message);
    }
}
