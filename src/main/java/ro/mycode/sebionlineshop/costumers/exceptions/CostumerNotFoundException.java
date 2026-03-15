package ro.mycode.sebionlineshop.costumers.exceptions;

public class CostumerNotFoundException extends RuntimeException {
    public CostumerNotFoundException(String message) {
        super(message);
    }
}
