package ro.mycode.sebionlineshop.categories.exceptions;

public class CategoryAlreadyexistsException extends RuntimeException {
    public CategoryAlreadyexistsException(String message) {
        super(message);
    }
}
