package ro.mycode.sebionlineshop.costumers.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;
import ro.mycode.sebionlineshop.system.exceptions.ApiErrorResponse;
import ro.mycode.sebionlineshop.system.exceptions.GlobalExceptionHandler;

public class CostumerAlreadyExistsException extends RuntimeException {
    public CostumerAlreadyExistsException() {
        super(ErrorConstants.COSTUMER_ALREADY_EXISTS);
    }
}
