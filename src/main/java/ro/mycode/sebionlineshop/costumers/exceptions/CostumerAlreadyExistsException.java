package ro.mycode.sebionlineshop.costumers.exceptions;

public class CostumerAlreadyExistsException extends RuntimeException {
    public CostumerAlreadyExistsException(String message) {
        super(message);
    }
}
