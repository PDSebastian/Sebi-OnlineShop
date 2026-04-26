package ro.mycode.sebionlineshop.costumers.exceptions;

import ro.mycode.sebionlineshop.system.constants.ErrorConstants;

public class CostumerNotFoundException extends RuntimeException {
    public CostumerNotFoundException() {
        super(ErrorConstants.COSTUMER_NOT_FOUND_EXCEPTION);
    }
}
